package ed.inf.adbs.lightdb.statements;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import ed.inf.adbs.lightdb.statements.Operators.*;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.statement.select.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that parses select statement, creates and executes the query plan
 */
public class SelectStatement {
    private List<String> selectItems = new ArrayList<>();
    private Expression where;

    private Distinct distinct;
    private List<OrderByElement> orderBy = new ArrayList<>();
    private GroupByElement groupBy;

    private List<String> tables = new ArrayList<>();
    private HashMap<String, Expression> selectConditionsMap = new HashMap<>(); // <table, corresponding select
                                                                               // conditions>
    private HashMap<String, Expression> joinConditionsMap = new HashMap<>(); // <table, corresponding join conditions>
    private SelectItem<?> sumExpression;
    private Map<String, Set<String>> necessaryColumns = new HashMap<>();
    private boolean selectAllFlag = false;

    /**
     * Constructor of Select statement
     * 
     * @param select select statement of type PlainSelect
     */
    public SelectStatement(PlainSelect select) {
        this.distinct = select.getDistinct();
        this.orderBy = select.getOrderByElements();
        this.groupBy = select.getGroupBy();

        HashMap<String, String> aliaseMap = new HashMap<>(); // <alias, tableName>
        FromItem fromItem = select.getFromItem();
        handleFromItem(fromItem, aliaseMap);
        // store join tables to tables list and with corresponding alias if exists
        List<Join> joins = select.getJoins();
        if (joins != null) {
            for (Join join : joins) {
                FromItem fromJoinItem = join.getRightItem();
                handleFromItem(fromJoinItem, aliaseMap);
            }
        }
        DatabaseCatalog.setAliasMap(aliaseMap);

        // hashmap for <table, where condition> for select condition
        HashMap<String, List<Expression>> whereSelectOnly = new HashMap<>();
        // hashmap for <table, where condition> for join condition
        HashMap<String, List<Expression>> whereJoinOnly = new HashMap<>();
        for (String table : this.tables) {
            whereSelectOnly.put(table, new ArrayList<>());
            whereJoinOnly.put(table, new ArrayList<>());
            this.necessaryColumns.put(table, new HashSet<>());
        }

        this.where = select.getWhere();
        if (this.where != null) {
            List<Expression> whereExpressionList = splitWhereExpression(select.getWhere());
            for (Expression expression : whereExpressionList) {
                List<String> tablesInvolved = parseTablesInvolved(expression);
                int lastTable = getLastTablePosition(tablesInvolved);
                String tableName = this.tables.get(lastTable);
                /*
                 * if two tables are involved, then it is a join condition else a select
                 * condition
                 */
                if (tablesInvolved.size() == 2) {
                    whereJoinOnly.get(tableName).add(expression);
                } else {
                    whereSelectOnly.get(tableName).add(expression);
                }
            }
        }

        // join the select and join conditions specific to a table and store in map
        for (String table : this.tables) {
            this.selectConditionsMap.put(table, joinWhereExpression(whereSelectOnly.get(table)));
            this.joinConditionsMap.put(table, joinWhereExpression(whereJoinOnly.get(table)));
        }

        // build necessary columns for projection pushdown
        List<SelectItem<?>> selectList = select.getSelectItems();
        String lastSelectItem = selectList.get(selectList.size() - 1).toString();
        this.selectAllFlag = Objects.equals(selectList.toString(), "[*]");
        if (lastSelectItem.contains("SUM")) { // extract the sum expression if it is present in the last select item
            this.sumExpression = selectList.get(selectList.size() - 1);
        }
        if (!this.selectAllFlag) {
            for (SelectItem<?> selectItem : selectList) {
                String item = selectItem.toString();
                this.selectItems.add(item);
            }
        }
        if (this.orderBy != null) {
            for (OrderByElement element : this.orderBy) {
                String tableName = element.toString().split("\\.")[0];
                this.necessaryColumns.get(tableName).add(element.toString());
            }
        }
        if (groupBy != null) {
            String groupByExpression = groupBy.getGroupByExpressionList().toString();
            if (groupByExpression.contains(",")) {
                String[] split = groupByExpression.split("\\s*,\\s*");
                for (String column : split) {
                    String tableName = column.split("\\.")[0];
                    this.necessaryColumns.get(tableName).add(column);
                }
            } else {
                String tableName = groupByExpression.split("\\.")[0];
                this.necessaryColumns.get(tableName).add(groupByExpression);
            }
        }
        if (sumExpression != null) {
            Pattern pattern = Pattern.compile("SUM\\((.*?)\\)");
            Matcher matcher = pattern.matcher(sumExpression.toString());
            if (matcher.find()) {
                String insideSum = matcher.group(1);
                if (insideSum.contains("*")) {
                    String[] sumExpressionList = insideSum.split("\\s*\\*\\s*");
                    for (String str : sumExpressionList) {
                        if (str.contains(".")) {
                            String tableName = str.split("\\.")[0];
                            this.necessaryColumns.get(tableName).add(str);
                        }
                    }
                } else {
                    if (insideSum.contains(".")) {
                        String tableName = insideSum.split("\\.")[0];
                        this.necessaryColumns.get(tableName).add(insideSum);
                    }
                }
            }
        }
    }

    /**
     * Generates relational algebra query plan and executes the query
     */
    public void executeQuery() {
        String rootTable = this.tables.get(0);
        Operator rootOperator = new ScanOperator(rootTable);
        Expression rootExpression = this.selectConditionsMap.get(rootTable);
        if (rootExpression != null) {
            rootOperator = new SelectOperator((ScanOperator) rootOperator, rootExpression);
        }
        //projection pushdown
        if (!this.selectAllFlag) {
            Set<String> columns = this.necessaryColumns.get(rootTable);
            if (!columns.isEmpty()) {
                rootOperator = new ProjectOperator(rootOperator, new ArrayList<>(columns));
            }
        }
        // create join operators for other tables
        for (int i = 1; i < this.tables.size(); i++) {
            String table = this.tables.get(i);
            Operator operator = new ScanOperator(table);
            Expression selectExpression = this.selectConditionsMap.get(table);
            if (selectExpression != null) {
                operator = new SelectOperator((ScanOperator) operator, selectExpression);
            }
            //projection pushdown
            if (!this.selectAllFlag) {
                Set<String> columns = this.necessaryColumns.get(table);
                if (!columns.isEmpty()) {
                    operator = new ProjectOperator(operator, new ArrayList<>(columns));
                }
            }
            Expression joinExpression = this.joinConditionsMap.get(table);
            rootOperator = new JoinOperator(rootOperator, operator, joinExpression);
        }
        if (this.groupBy != null || this.sumExpression != null) {
            rootOperator = new SumOperator(rootOperator, this.groupBy, this.sumExpression);
            rootOperator = new ProjectOperator(((SumOperator) rootOperator).getResults(), this.selectItems);

            if (this.orderBy != null || this.distinct != null) {
                rootOperator = new SortOperator(((ProjectOperator) rootOperator).getAllProjectedTuples(), this.orderBy);
                if (this.distinct != null) {
                    /*
                     * eliminate duplicates in sorted tuples if query has order by and distinct
                     */
                    rootOperator = new DuplicateEliminationOperator(rootOperator,
                            ((SortOperator) rootOperator).getSortedTuples());
                    rootOperator.dump(((DuplicateEliminationOperator) rootOperator).getUniquetuples());
                } else {
                    /*
                     * return the sorted tuples if query has order by without distinct
                     */
                    rootOperator.dump(((SortOperator) rootOperator).getSortedTuples());
                }
            } else {
                rootOperator.dump(((ProjectOperator) rootOperator).getAllProjectedTuples());
            }
            return;
        }
        if (!this.selectAllFlag) {
            rootOperator = new ProjectOperator(rootOperator, this.selectItems);
        }
        if (this.orderBy != null || this.distinct != null) {
            rootOperator = new SortOperator(rootOperator, this.orderBy);
            if (this.distinct != null) {
                /*
                 * eliminate duplicates in sorted tuples if query has order by and distinct
                 */
                rootOperator = new DuplicateEliminationOperator(rootOperator,
                        ((SortOperator) rootOperator).getSortedTuples());
                rootOperator.dump(((DuplicateEliminationOperator) rootOperator).getUniquetuples());
            } else {
                /*
                 * return the sorted tuples if query has order by without distinct
                 */
                rootOperator.dump(((SortOperator) rootOperator).getSortedTuples());
            }
            return;
        }
        rootOperator.dump();
    }

    /**
     * Returns the position of table lastly added to the tables list
     * from the tables in join condition
     * 
     * @param tablesInvolved list of tables in the expression
     * @return index of last table in the tables
     */
    private int getLastTablePosition(List<String> tablesInvolved) {
        int latestIndex = 0;
        for (String table : tablesInvolved) {
            String[] split = table.split("\\.");
            int tableIndex = this.tables.indexOf(split[0]);
            if (tableIndex > latestIndex) {
                latestIndex = tableIndex;
            }
        }
        return latestIndex;
    }

    /**
     * Parses an expression and returns a list of tables in the expression
     * 
     * @param expression expression
     * @return list of tables in the expression
     */
    private List<String> parseTablesInvolved(Expression expression) {
        List<String> tablesInvolved = new ArrayList<>();
        String[] splitExpression = expression.toString().split("\\s+");
        String left = splitExpression[0];
        String right = splitExpression[2];
        // check if left side of operator is a table
        if (left.contains(".")) {
            tablesInvolved.add(left);
            String tableName = left.split("\\.")[0];
            this.necessaryColumns.get(tableName).add(left);
        }
        // check if right side of operator is a table
        if (right.contains(".")) {
            // if the join is a self join skip adding the same table again
            if (!tablesInvolved.contains(right)) {
                tablesInvolved.add(right);
            }
            String tableName = right.split("\\.")[0];
            this.necessaryColumns.get(tableName).add(right);
        }
        return tablesInvolved;
    }

    /**
     * Store from table to tables list and add it to aliasMap if alias exists
     * 
     * @param fromItem from table
     * @param aliasMap mapping from alias to table
     */
    private void handleFromItem(FromItem fromItem, HashMap<String, String> aliasMap) {
        Alias fromItemAlias = fromItem.getAlias();
        if (fromItemAlias != null) {
            String[] split = fromItem.toString().split("\\s+");
            aliasMap.put(fromItemAlias.getName(), split[0]);
            this.tables.add(fromItemAlias.getName());
        } else {
            this.tables.add(fromItem.toString());
        }
    }

    /**
     * Split single expression into it's constituent expressions
     * 
     * @param whereExpression single 'where' expression of the query
     * @return list of constituent expressions
     */
    private List<Expression> splitWhereExpression(Expression whereExpression) {
        /*
         * For where expression with more than two conditions,
         * the expression is of type AndExpression and the ast
         * is left deep with the deeply nested left AndExpressions
         * and simple right expression (Eg: equalsTo etc)
         */
        List<Expression> splitWhereExpressions = new ArrayList<>();
        while (whereExpression instanceof AndExpression) {
            AndExpression currentNode = (AndExpression) this.where;
            splitWhereExpressions.add(currentNode.getRightExpression());
            whereExpression = currentNode.getLeftExpression();
        }
        splitWhereExpressions.add(whereExpression);
        return splitWhereExpressions;
    }

    /**
     * Join constituent expressions into single expression
     * 
     * @param whereExpressionList list of expressions to join
     * @return joined expression
     */
    private Expression joinWhereExpression(List<Expression> whereExpressionList) {
        // static condition without any table involvement
        if (whereExpressionList.isEmpty()) {
            return null;
        }
        Expression joinedExpression = whereExpressionList.get(0);
        for (int i = 1; i < whereExpressionList.size(); i++) {
            joinedExpression = new AndExpression(joinedExpression, whereExpressionList.get(i));
        }
        return joinedExpression;
    }
}
