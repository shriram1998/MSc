package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import ed.inf.adbs.lightdb.statements.Evaluators.SelectExpressionEvaluator;
import net.sf.jsqlparser.expression.Expression;

/**
 * Select operator class
 */
public class SelectOperator extends Operator{
    private ScanOperator scanOperator;
    private Expression whereCondition;
    /**
     * SelectOperator constructor
     * @param childScanOperator Child operator
     * @param condition where expression to evaluate
     */
    public SelectOperator(ScanOperator childScanOperator, Expression condition) {
        this.scanOperator = childScanOperator;
        this.whereCondition = condition;
    }
    /**
     * Return the next tuple that satisfies the where condition
     * @return next tuple that satisfies the where condition
     */
    @Override
    public Tuple getNextTuple(){
        Tuple tuple = this.scanOperator.getNextTuple();
        SelectExpressionEvaluator evaluator=new SelectExpressionEvaluator(this.whereCondition);
        while (tuple != null) {
            if(evaluator.evaluate(tuple)){
                return tuple;
            }
            tuple=this.scanOperator.getNextTuple();
        }
        return null; // No more tuples or no tuple matches
    }
    /**
     * Calls the child scan operator's reset method
     */
    @Override
    public void reset() {
        this.scanOperator.reset();
    }
}
