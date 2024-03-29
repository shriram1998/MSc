package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import ed.inf.adbs.lightdb.statements.Evaluators.JoinExpressionEvaluator;
import net.sf.jsqlparser.expression.Expression;

/**
 * Join operator class
 */
public class JoinOperator extends Operator {
    private Operator leftOperator;
    private Operator rightOperator;
    private Tuple leftTuple;
    private Tuple rightTuple;
    private Expression expression;

    /**
     * JoinOperator constructor
     * 
     * @param leftOp  left or outer table operator
     * @param rightOp right or inner table operator
     * @param expr    join condition
     */
    public JoinOperator(Operator leftOp, Operator rightOp, Expression expr) {
        this.leftOperator = leftOp;
        this.rightOperator = rightOp;
        this.expression = expr;
        this.leftTuple = this.leftOperator.getNextTuple();
        this.rightTuple = this.rightOperator.getNextTuple();
    }

    /**
     * Returns the next tuple after performing simple nested loop join
     * 
     * @return next tuple of join operation if possible else returns null
     */
    @Override
    public Tuple getNextTuple() {
        JoinExpressionEvaluator evaluator = new JoinExpressionEvaluator(expression);
        while (this.leftTuple != null) {
            Tuple tuple = null;
            if (this.expression == null || evaluator.evaluate(this.leftTuple, this.rightTuple)) {
                tuple = new Tuple(this.leftTuple, this.rightTuple);
            }
            this.rightTuple = this.rightOperator.getNextTuple();
            if (this.rightTuple == null) {
                this.rightOperator.reset();
                this.rightTuple = this.rightOperator.getNextTuple();
                this.leftTuple = this.leftOperator.getNextTuple();
            }
            if (tuple != null)
                return tuple;
        }
        return null; // No more matches found
    }

    /**
     * Not used since SNLJ
     */
    @Override
    public void reset() {
    }
}
