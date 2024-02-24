package ed.inf.adbs.lightdb.core.executor.operators;
import java.io.IOException;
import java.io.PrintStream;

import ed.inf.adbs.lightdb.model.Tuple;

public abstract class Operator {
    /**
     * Gets the next tuple from the operator.
     * @return The next tuple if available, or null if there are no more tuples.
     */
    public abstract Tuple getNextTuple() throws IOException;

    /**
     * Resets the operator to its initial state, allowing it to start returning tuples from the beginning.
     */
    public abstract void reset() throws IOException;

    /**
     * Repeatedly calls getNextTuple() until the next tuple is null
     * @param out The PrintStream to which tuples are written.
     */
    public void dump(PrintStream out) throws IOException {
        reset(); // Ensure the operator starts from the beginning
        Tuple tuple;
        while ((tuple = getNextTuple()) != null) {
            out.println(tuple.toString());
        }
    }
}
