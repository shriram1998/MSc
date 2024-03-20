package ed.inf.adbs.lightdb.statements.Evaluators;

import ed.inf.adbs.lightdb.models.Tuple;
import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

import java.util.Stack;

public class SelectExpressionEvaluator extends ExpressionDeParser{
    private Tuple tuple;
    private Expression expression;
    Stack<Boolean> evaluationResult = new Stack<>(); // Stores the result of expression evaluation
    Stack<Long> lastValueStack = new Stack<>(); //store last visited value
    /**
     * Constructor of SelectExpressionEvaluator
     * @param whereExpression Where condition expression
     */
    public SelectExpressionEvaluator(Expression whereExpression) {
        expression=whereExpression;
    }

    public Boolean evaluate(Tuple currentTuple) {
        evaluationResult = new Stack<>();
        lastValueStack = new Stack<>();
        tuple=currentTuple;
        expression.accept(this);
        return evaluationResult.pop();
    }

    @Override
    public void visit(Column column) {
        super.visit(column);
        int index = DatabaseCatalog.getColumnPosition(column.toString());
        lastValueStack.push(tuple.getTupleField(index));
    }

    @Override
    public void visit(LongValue longValue) {
        super.visit(longValue);
        lastValueStack.push(longValue.getValue());
    }

    //Store the result of = comparison in the result stack
    @Override
    public void visit(EqualsTo equalsTo) {
        super.visit(equalsTo);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue == rightValue);
    }

    //Store the result of < comparison in the result stack
    @Override
    public void visit(MinorThan minorThan) {
        super.visit(minorThan);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue < rightValue);
    }

    //Store the result of <= comparison in the result stack
    @Override
    public void visit(MinorThanEquals minorThanEquals) {
        super.visit(minorThanEquals);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue <= rightValue);
    }

    //Store the result of > comparison in the result stack
    @Override
    public void visit(GreaterThan greaterThan) {
        super.visit(greaterThan);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue > rightValue);
    }
    //Store the result of > comparison in the result stack
    @Override
    public void visit(GreaterThanEquals greaterThanEquals) {
        super.visit(greaterThanEquals);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue >= rightValue);
    }
    //Store the result of != comparison in the result stack
    @Override
    public void visit(NotEqualsTo notEqualsTo) { //pushes the result of a notEqualsTo comparison to the stack
        super.visit(notEqualsTo);
        long rightValue = lastValueStack.pop();
        long leftValue = lastValueStack.pop();
        evaluationResult.push(leftValue != rightValue);
    }
    //Store the result of and expression in the result stack
    @Override
    public void visit(AndExpression andExpression) {
        super.visit(andExpression);
        boolean rightResult = evaluationResult.pop();
        boolean leftResult = evaluationResult.pop();
        evaluationResult.push(leftResult && rightResult);
    }

    //Store the result of or expression in the result stack
    @Override
    public void visit(OrExpression orExpression) {
        super.visit(orExpression);
        boolean rightResult = evaluationResult.pop();
        boolean leftResult = evaluationResult.pop();
        evaluationResult.push(leftResult || rightResult);
    }
}