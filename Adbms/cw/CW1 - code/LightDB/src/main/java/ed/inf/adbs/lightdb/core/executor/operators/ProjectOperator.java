package ed.inf.adbs.lightdb.core.executor.operators;

import ed.inf.adbs.lightdb.metadata.Catalog;
import ed.inf.adbs.lightdb.model.Tuple;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.schema.Column;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ProjectOperator extends Operator {
    private final Catalog catalog=Catalog.getInstance();
    private final Operator childOperator;
    private final Map<String, Integer> columnMapping; // Column name to index mapping
    private final ArrayList<String> columnNames;
    private final ArrayList<LongValue> constants;
    public ProjectOperator(Operator childOperator, List<SelectItem<?>> selectItems, Map<String, Integer> columnMapping) {
        this.childOperator = childOperator;
        this.constants = new ArrayList<>();
        this.columnNames = new ArrayList<>();
        this.columnMapping = columnMapping;

        // Determine which columns to project
        for (SelectItem<?> item : selectItems) {
            Expression expression=item.getExpression();
            if (expression instanceof AllColumns) {
                this.columnNames.clear(); // Clear any previously added columns if SELECT *
                break;
            } else if (expression instanceof Column) {
                this.columnNames.add(((Column) expression).getColumnName());
            } else if (expression instanceof LongValue){
                LongValue longValue= (LongValue) expression;
                this.constants.add(longValue);
            }
        }
    }

    @Override
    public Tuple getNextTuple() throws IOException {
        Tuple tuple = childOperator.getNextTuple();
        if (tuple == null) return null;

        if (columnNames.isEmpty()) {
            if(constants.isEmpty()){
                return tuple; // If SELECT *, return the original tuple
            }else{
                //implement constant addition later
                return tuple;
            }
        }

        // Otherwise, create a new tuple with only the specified columns
        ArrayList<Integer> projectedTuple = new ArrayList<>();
        for (String columnName : columnNames) {
            int index = columnMapping.get(columnName);
            int value = tuple.getField(index);
            projectedTuple.add(value);
        }
        int[] intArray = projectedTuple.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println("Returning from project"+ Arrays.toString(intArray));
        return new Tuple(intArray);
    }

    @Override
    public void reset() throws IOException {
        childOperator.reset();
    }
}

