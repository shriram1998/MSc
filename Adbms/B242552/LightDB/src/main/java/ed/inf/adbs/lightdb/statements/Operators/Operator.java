package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import ed.inf.adbs.lightdb.models.Tuple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract operator class that describes the interface
 * that relational algebra operators should implement
 */
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

    /**
     * Dump method to dump all the tuples at the same time
     * that is used with queries containing order by
     */
    public void dump(List<Tuple> tuples){
        try{
            String outputFilePath= DatabaseCatalog.getOutputPath();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true));
            if(tuples.isEmpty()){
                writer.close();
                return;
            }
            for(Tuple tuple:tuples) {
                String strToWrite = tuple.toString() + "\n";
                writer.write(strToWrite);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all output tuples of an operator as a list (to support blocking operators like order by)
     * @return list of all output tuples
     */
    public List<Tuple> getAllTuples() {
        List<Tuple> allTuples=new ArrayList<>();
        Tuple tuple;
        while ((tuple = getNextTuple()) != null) {
            allTuples.add(tuple);
        }
        return allTuples;
    }
}
