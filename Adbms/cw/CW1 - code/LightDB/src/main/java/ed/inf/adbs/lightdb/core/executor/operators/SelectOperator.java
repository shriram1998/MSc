package ed.inf.adbs.lightdb.core.executor.operators;

import ed.inf.adbs.lightdb.core.executor.ExpressionEvaluator;
import ed.inf.adbs.lightdb.model.Tuple;
import net.sf.jsqlparser.expression.Expression;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class SelectOperator extends Operator {
    private final Operator childOperator;
    private final Expression whereCondition;
    private final Map<String, Integer> schema;

    public SelectOperator(Operator childOperator, Expression whereCondition, Map<String, Integer> schema) {
        this.childOperator = childOperator;
        this.whereCondition = whereCondition;
        this.schema = schema;
    }

    @Override
    public Tuple getNextTuple() throws IOException {
        Tuple tuple = childOperator.getNextTuple();
        ExpressionEvaluator evaluator = new ExpressionEvaluator(schema);
        while (tuple != null) {
            if (evaluator.evaluate(whereCondition, tuple)) {
//                System.out.println("Returning from select"+ tuple);
                return tuple; // Tuple matches the condition
            }
            tuple = childOperator.getNextTuple(); // Fetch next and repeat
        }
        return null; // No more tuples or no tuple matches
    }

    @Override
    public void reset() throws IOException {
        childOperator.reset();
    }
}
