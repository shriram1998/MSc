package ed.inf.adbs.lightdb.statements.Evaluators;

import ed.inf.adbs.lightdb.models.Tuple;
import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

import java.util.Stack;
/**
 * Custom expression deparser class that inherits ExpressionDeParser
 * and also implement an evaluate method to evaluate the select condition
 * on a tuple
 */
public class SelectExpressionEvaluator extends ExpressionDeParser{
    private Tuple tuple;
    private Expression expression;
    Stack<Boolean> evaluationResult = new Stack<>(); // Stores the result of expression evaluation
    Stack<Integer> lastValueStack = new Stack<>(); //store last visited value
    /**
     * Constructor of SelectExpressionEvaluator
     * @param whereExpression Where condition expression
     */
    public SelectExpressionEvaluator(Expression whereExpression) {
        this.expression=whereExpression;
    }

    /**
     * Returns evaluation result of the tuple for the expression
     * @param currentTuple current tuple
     */
    public Boolean evaluate(Tuple currentTuple) {
        this.evaluationResult = new Stack<>();
        this.lastValueStack = new Stack<>();
        this.tuple=currentTuple;
        this.expression.accept(this);
        return this.evaluationResult.pop();
    }

    @Override
    public void visit(Column column) {
        super.visit(column);
        int index = DatabaseCatalog.getColumnPosition(column.toString());
        System.out.println(column);
        System.out.println(index);
        this.lastValueStack.push(this.tuple.getTupleField(index));
    }

    @Override
    public void visit(LongValue longValue) {
        super.visit(longValue);
        System.out.println(longValue);
        this.lastValueStack.push((int) longValue.getValue());
    }

    //Store the result of = comparison in the result stack
    @Override
    public void visit(EqualsTo equalsTo) {
        super.visit(equalsTo);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue == rightValue);
    }

    //Store the result of < comparison in the result stack
    @Override
    public void visit(MinorThan minorThan) {
        super.visit(minorThan);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue < rightValue);
    }

    //Store the result of <= comparison in the result stack
    @Override
    public void visit(MinorThanEquals minorThanEquals) {
        super.visit(minorThanEquals);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue <= rightValue);
    }

    //Store the result of > comparison in the result stack
    @Override
    public void visit(GreaterThan greaterThan) {
        super.visit(greaterThan);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue > rightValue);
    }
    //Store the result of > comparison in the result stack
    @Override
    public void visit(GreaterThanEquals greaterThanEquals) {
        super.visit(greaterThanEquals);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue >= rightValue);
    }
    //Store the result of != comparison in the result stack
    @Override
    public void visit(NotEqualsTo notEqualsTo) { //pushes the result of a notEqualsTo comparison to the stack
        super.visit(notEqualsTo);
        int rightValue = this.lastValueStack.pop();
        int leftValue = this.lastValueStack.pop();
        this.evaluationResult.push(leftValue != rightValue);
    }
    //Store the result of and expression in the result stack
    @Override
    public void visit(AndExpression andExpression) {
        super.visit(andExpression);
        boolean rightResult = this.evaluationResult.pop();
        boolean leftResult = this.evaluationResult.pop();
        this.evaluationResult.push(leftResult && rightResult);
    }

    //Store the result of or expression in the result stack
    @Override
    public void visit(OrExpression orExpression) {
        super.visit(orExpression);
        boolean rightResult = this.evaluationResult.pop();
        boolean leftResult = this.evaluationResult.pop();
        this.evaluationResult.push(leftResult || rightResult);
    }
}
