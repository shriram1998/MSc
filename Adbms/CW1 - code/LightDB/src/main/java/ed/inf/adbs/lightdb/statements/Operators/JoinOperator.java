package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import ed.inf.adbs.lightdb.statements.Evaluators.JoinExpressionEvaluator;
import net.sf.jsqlparser.expression.Expression;

/**
 * Join operator class
 */
public class JoinOperator extends Operator{
    private Operator leftOperator;
    private Operator rightOperator;
    private Tuple leftTuple;
    private Tuple rightTuple;
    private Expression expression;
    /**
     * JoinOperator constructor
     * @param leftOp left or outer table operator
     * @param rightOp right or inner table operator
     * @param expr join condition
     */
    public JoinOperator(Operator leftOp, Operator rightOp, Expression expr){
        leftOperator=leftOp;
        rightOperator=rightOp;
        expression=expr;
        leftTuple = leftOperator.getNextTuple();
        rightTuple = rightOperator.getNextTuple();
    }
    /**
     * Returns the next tuple after performing simple nested loop join
     * @return next tuple of join operation if possible else returns null
     */
    @Override
    public Tuple getNextTuple() {
        JoinExpressionEvaluator evaluator=new JoinExpressionEvaluator(expression);
        while (leftTuple != null) {
            Tuple tuple=null;
            if (evaluator.evaluate(leftTuple, rightTuple)) {
                tuple=new Tuple(leftTuple, rightTuple);
            }
            rightTuple = rightOperator.getNextTuple();
            if(rightTuple==null){
                rightOperator.reset();
                rightTuple=rightOperator.getNextTuple();
                leftTuple=leftOperator.getNextTuple();
            }
            if(tuple!=null) return tuple;
        }
        return null; // No more matches found
    }

    //not used due to SNLJ
    @Override
    public void reset() {
    }
}
