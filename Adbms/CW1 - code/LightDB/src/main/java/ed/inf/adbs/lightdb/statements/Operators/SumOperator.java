package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import net.sf.jsqlparser.statement.select.GroupByElement;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sum operator class
 */
public class SumOperator extends Operator {
    private Operator childOperator;
    private GroupByElement groupBy;
    private SelectItem<?> sumExpression;
    private Integer sumResultWithoutGroupBy;
    private String[] sumExpressionList;
    private Map<List<Integer>, Integer> sumMap = new HashMap<>(); // <groupby key, sum aggregation>
    private Set<List<Integer>> groupByWithoutSum = new HashSet<>();
    private List<String> schema = new ArrayList<>();

    public SumOperator(Operator operator, GroupByElement groupBy, SelectItem<?> sumExpression) {
        this.childOperator = operator;
        this.groupBy = groupBy;
        this.sumExpression = sumExpression;

        Tuple tuple = this.childOperator.getNextTuple();
        if (tuple == null)
            return;
        List<String> tupleSchema = tuple.getTupleSchema();

        // build the column index list of group by columns
        List<Integer> groupByAttributeIndexList = new ArrayList<>();
        if (groupBy != null) {
            String groupByExpression = groupBy.getGroupByExpressionList().toString();
            if (groupByExpression.contains(",")) {
                String[] split = groupByExpression.split("\\s*,\\s*");
                for (String column : split) {
                    groupByAttributeIndexList.add(tupleSchema.indexOf(column));
                    this.schema.add(column);
                }
            } else {
                groupByAttributeIndexList.add(tupleSchema.indexOf(groupByExpression));
                this.schema.add(groupByExpression);
            }
        }
        // extract sum aggregate expression
        if (sumExpression != null) {
            Pattern pattern = Pattern.compile("SUM\\((.*?)\\)");
            Matcher matcher = pattern.matcher(sumExpression.toString());
            if (matcher.find()) {
                String insideSum = matcher.group(1);
                if (insideSum.contains("*")) {
                    this.sumExpressionList = insideSum.split("\\s*\\*\\s*");
                } else {
                    this.sumExpressionList = new String[] { insideSum };
                }
            }
            /*
             * add sum attribute if there is a sum aggregate
             */
            this.schema.add("sum");
        }

        if (groupBy != null && sumExpression != null) {
            // Group by with sum aggregate Eg: SELECT Sailors.A. SUM(5*Sailors.b) FROM
            // Sailors GROUP BY Sailors.A
            while (tuple != null) {
                Integer sumAttributeValue = processSumExpression(tuple, this.sumExpressionList);
                List<Integer> groupByAttributeValue = new ArrayList<>();
                for (Integer attributeIndex : groupByAttributeIndexList) {
                    groupByAttributeValue.add(tuple.getTupleField(attributeIndex));
                }
                this.sumMap.put(groupByAttributeValue,
                        this.sumMap.getOrDefault(groupByAttributeValue, 0) + sumAttributeValue);
                tuple = this.childOperator.getNextTuple();
            }
        } else if (groupBy != null) {
            // Eg: Group by without sum aggregate. Eg: SELECT Sailors.A FROM Sailors GROUP
            // BY Sailors.A
            while (tuple != null) {
                List<Integer> groupByAttributeValue = new ArrayList<>();
                for (Integer attributeIndex : groupByAttributeIndexList) {
                    groupByAttributeValue.add(tuple.getTupleField(attributeIndex));
                }
                this.groupByWithoutSum.add(groupByAttributeValue);
                tuple = this.childOperator.getNextTuple();
            }
        } else if (sumExpression != null) {
            /*
             * Queries with sum aggregate without group by. Eg: "Select SUM(1) From Sailors"
             */
            this.sumResultWithoutGroupBy = 0;
            while (tuple != null) {
                Integer sumAttributeValue = processSumExpression(tuple, this.sumExpressionList);
                this.sumResultWithoutGroupBy += sumAttributeValue;
                tuple = this.childOperator.getNextTuple();
            }
        }
    }

    /**
     * Return the sum value for the tuple based on the sum expression to be added to
     * the aggregate
     * 
     * @return sum value for the tuple
     */
    private Integer processSumExpression(Tuple tuple, String[] sumExpressionList) {
        int result;
        // if the aggregate is only for a single term either constant or column
        if (sumExpressionList.length == 1) {
            if (sumExpressionList[0].contains(".")) { // column in the tuple
                result = tuple.getTupleField(tuple.getAttributeIndex(sumExpressionList[0]));
            } else {
                result = Integer.parseInt(sumExpressionList[0]);
            }
        } else { // product of terms
            int localSum = 1;
            for (String s : sumExpressionList) {
                if (s.contains(".")) { // column in the tuple
                    int index = tuple.getAttributeIndex(s);
                    localSum *= tuple.getTupleField(index);
                    this.schema.add(s);
                } else {
                    localSum *= Integer.parseInt(s);
                }
            }
            result = localSum;
        }
        return result;
    }

    /**
     * Return the result of the sum aggregate with or without the presence of group
     * by
     * 
     * @return result of the query after sum aggregate
     */
    public List<Tuple> getResults() {
        List<Tuple> results = new ArrayList<>();
        if (this.sumExpression != null && this.groupBy != null) { // Eg: SELECT Sailors.A. SUM(5*Sailors.b) FROM Sailors
                                                                  // GROUP BY Sailors.A
            for (Map.Entry<List<Integer>, Integer> entry : sumMap.entrySet()) {
                List<Integer> values = new ArrayList<>(entry.getKey());
                int[] tuple = new int[values.size() + 1];
                for (int i = 0; i < values.size(); i++) {
                    tuple[i] = values.get(i);
                }
                tuple[values.size()] = entry.getValue();
                results.add(new Tuple(tuple, this.schema));
            }
        } else if (this.sumExpression != null && this.sumResultWithoutGroupBy != null) { // Eg: SELECT SUM(1) FROM
                                                                                         // Sailors
            results.add(new Tuple(new int[] { this.sumResultWithoutGroupBy }, this.schema));
        } else if (this.groupBy != null) { // Eg: SELECT Sailors.A FROM Sailors GROUP BY Sailors.A
            for (List<Integer> entry : this.groupByWithoutSum) {
                List<Integer> values = new ArrayList<>(entry);
                int[] tuple = new int[values.size()];
                for (int i = 0; i < values.size(); i++) {
                    tuple[i] = values.get(i);
                }
                results.add(new Tuple(tuple, this.schema));
            }
        }
        return results;
    }

    /**
     * Not used
     */
    @Override
    public Tuple getNextTuple() {
        return null;
    }

    /**
     * Not used
     */
    @Override
    public void reset() {
    }

}
