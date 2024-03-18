package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import ed.inf.adbs.lightdb.models.Tuple;

import java.io.*;

public abstract class Operator {
    /**
     * Gets the next tuple from the operator.
     * @return The next tuple if available, or null if there are no more tuples.
     */
    public abstract Tuple getNextTuple();

    /**
     * Resets the operator to its initial state, allowing it to start returning tuples from the beginning.
     */
    public abstract void reset();

    /**
     * Repeatedly calls getNextTuple() until the next tuple is null
     */
    public void dump(){
        Tuple tuple;
        String outputFilePath= DatabaseCatalog.getOutputPath();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true));
            while ((tuple = getNextTuple()) != null) {
                String strToWrite=tuple.toString()+"\n";
                writer.write(strToWrite);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
