package ed.inf.adbs.lightdb.core.executor;

import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

import java.util.*;

public class JoinExpressionEvaluator extends ExpressionDeParser {
//    private final Map<String, Expression> joinConditions = new HashMap<>();
//    private final Map<String, Expression> selectionConditions = new HashMap<>();
//    private final Set<String> tablesInvolved = new HashSet<>();
//
//    public JoinExpressionEvaluator() {
//        super();
//        this.setExpressionVisitor(new ExpressionVisitorAdapter() {
//            @Override
//            public void visit(Column column) {
//                tablesInvolved.add(column.getTable().getName());
//                super.visit(column);
//            }
//
//            // Override other methods to handle different expressions
//        });
//    }
//
//    @Override
//    public void visit(AndExpression andExpression) {
//        handleExpression(andExpression);
//    }
//
//    // Similar overrides for OrExpression, EqualsTo, GreaterThan, MinorThan, etc.
//
//    private void handleExpression(BinaryExpression expr) {
//        tablesInvolved.clear();
//        expr.getLeftExpression().accept(getExpressionVisitor());
//        expr.getRightExpression().accept(getExpressionVisitor());
//
//        if (tablesInvolved.size() > 1) {
//            // It's a join condition
//            joinConditions.put(String.join(" AND ", tablesInvolved), expr);
//        } else if (tablesInvolved.size() == 1) {
//            // It's a selection condition
//            String tableName = tablesInvolved.iterator().next();
//            selectionConditions.put(tableName, expr);
//        }
//    }
//
//    public Map<String, Expression> getJoinConditions() {
//        return joinConditions;
//    }
//
//    public Map<String, Expression> getSelectionConditions() {
//        return selectionConditions;
//    }
}

