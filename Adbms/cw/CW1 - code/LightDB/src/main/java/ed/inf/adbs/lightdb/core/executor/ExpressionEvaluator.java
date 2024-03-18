package ed.inf.adbs.lightdb.core.executor;
import ed.inf.adbs.lightdb.model.Tuple;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

import java.util.Map;

public class ExpressionEvaluator extends ExpressionVisitorAdapter {
    private Tuple currentTuple;
    private final Map<String, Integer> columnMapping; // Column name to index mapping
    private Boolean evaluationResult; // Stores the result of expression evaluation
    private Integer lastEvaluatedValue;

    public ExpressionEvaluator(Map<String, Integer> columnMapping) {
        this.columnMapping = columnMapping;
    }

    public boolean evaluate(Expression expression, Tuple tuple) {
        this.currentTuple = tuple;
        this.lastEvaluatedValue=null;
        this.evaluationResult = null; // Default to true, can be overridden by visit methods
        expression.accept(this);
        return evaluationResult != null && evaluationResult;
    }

    @Override
    public void visit(EqualsTo equalsTo) {
        equalsTo.getLeftExpression().accept(this);
        Integer leftValue = lastEvaluatedValue;
        equalsTo.getRightExpression().accept(this);
        Integer rightValue = lastEvaluatedValue;
        evaluationResult = leftValue != null && leftValue.equals(rightValue);
    }

    @Override
    public void visit(GreaterThan greaterThan) {
        greaterThan.getLeftExpression().accept(this);
        Integer leftValue = lastEvaluatedValue;
        greaterThan.getRightExpression().accept(this);
        Integer rightValue = lastEvaluatedValue;
        this.evaluationResult = leftValue > rightValue;
    }

    @Override
    public void visit(GreaterThanEquals greaterThanEquals) {
        greaterThanEquals.getLeftExpression().accept(this);
        Integer leftValue = lastEvaluatedValue;
        greaterThanEquals.getRightExpression().accept(this);
        Integer rightValue = lastEvaluatedValue;
        this.evaluationResult = leftValue >= rightValue;
    }

    @Override
    public void visit(MinorThan minorThan) {
        minorThan.getLeftExpression().accept(this);
        Integer leftValue = lastEvaluatedValue;
        minorThan.getRightExpression().accept(this);
        Integer rightValue = lastEvaluatedValue;
        this.evaluationResult = leftValue < rightValue;
    }

    @Override
    public void visit(MinorThanEquals minorThanEquals) {
        minorThanEquals.getLeftExpression().accept(this);
        Integer leftValue = lastEvaluatedValue;
        minorThanEquals.getRightExpression().accept(this);
        Integer rightValue = lastEvaluatedValue;
        this.evaluationResult = leftValue <= rightValue;
    }

    @Override
    public void visit(AndExpression andExpression) {
        // Evaluate the left side of the AND expression
        andExpression.getLeftExpression().accept(this);
        Boolean leftResult = this.evaluationResult;

        // Short-circuit evaluation: if the left side is false, no need to evaluate the right side
        if (Boolean.FALSE.equals(leftResult)) {
            this.evaluationResult = false;
        } else {
            // Evaluate the right side of the AND expression
            andExpression.getRightExpression().accept(this);
            Boolean rightResult = this.evaluationResult;
            // Combine results: both sides must be true for AND expression to be true
            this.evaluationResult = Boolean.TRUE.equals(leftResult) && Boolean.TRUE.equals(rightResult);
        }
    }

    @Override
    public void visit(OrExpression orExpression) {
        // Evaluate the left side of the OR expression
        orExpression.getLeftExpression().accept(this);
        Boolean leftResult = this.evaluationResult;

        // Short-circuit evaluation: if the left side is true, no need to evaluate the right side
        if (Boolean.TRUE.equals(leftResult)) {
            this.evaluationResult = true;
        } else {
            // Evaluate the right side of the OR expression
            orExpression.getRightExpression().accept(this);
            Boolean rightResult = this.evaluationResult;
            // Combine results: either side can be true for OR expression to be true
            this.evaluationResult = Boolean.TRUE.equals(leftResult) || Boolean.TRUE.equals(rightResult);
        }
    }

    @Override
    public void visit(Column column) {
        String columnName = column.getColumnName();
        Integer index = columnMapping.get(columnName);
        if (index == null) {
            throw new IllegalArgumentException("Column " + columnName + " not found in schema.");
        }
        // Fetch the column value from the tuple and store it for comparison
//        System.out.println("Index"+index);
//        System.out.println("Mapping"+columnMapping);
//        System.out.println("Tuple"+currentTuple);
//        System.out.println("Col Field:"+currentTuple.getField(index));
        lastEvaluatedValue = (int) currentTuple.getField(index);
    }

    @Override
    public void visit(LongValue longValue) {
        // Directly store the long value for comparison
        lastEvaluatedValue = (int) longValue.getValue();
//        System.out.println("Long Field:"+lastEvaluatedValue);
    }
}