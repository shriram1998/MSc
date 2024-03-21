package ed.inf.adbs.lightdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a tuple in the LightDB system
 * A tuple corresponds to a row of data in a table
 * Implements methods to handle tuple array and metadata of tuple that is Column names
 */
public class Tuple {
    private final long[] tuple;
    private final List<String> tupleSchema;

    /**
     * Constructs a tuple with the specified fields
     * @param fields The fields of the tuple
     * @param schema The schema of the tuple
     */
    public Tuple(long[] fields, List<String> schema) {
        this.tuple = fields;
        this.tupleSchema=schema;
    }

    /**
     * Constructs a tuple which is a combination of two tuples
     * @param leftTuple left tuple
     * @param rightTuple right tuple
     */
    public Tuple(Tuple leftTuple, Tuple rightTuple) {
        int leftTupleSize=leftTuple.getSize();
        tuple = new long[leftTupleSize+rightTuple.getSize()];
        for(int i=0;i<tuple.length;i++){
            if(i<leftTupleSize){ //fill the left tuple fields in the result tuple
                tuple[i]=leftTuple.getTupleField(i);
            } else{
                tuple[i]= rightTuple.getTupleField(i-leftTupleSize);
            }
        }
        //create new schema which is a combination of left and right tuple schema
        tupleSchema=new ArrayList<>(leftTuple.getTupleSchema());
        tupleSchema.addAll(rightTuple.getTupleSchema());
    }

    /**
     * Retrieves the value of a tuple at the specified index
     * @param index The index of the field to retrieve
     * @return The value of the field
     */
    public long getTupleField(int index) {
        return this.tuple[index];
    }

    /**
     * Returns size of the tuple
     * @return tuple size
     */
    public int getSize() {
        return tuple.length;
    }

    /**
     * Returns a string representation of the tuple
     * @return A string representation of the tuple
     */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<tuple.length;++i){
            sb.append(tuple[i]);
            if(i!=tuple.length-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Return the position of the attribute
     * @param attributeName attribute name
     * @return index position of the attribute
     */
    public int getAttributeIndex(String attributeName) {
        if(Objects.equals(attributeName, "*")){
            return -1; //Select *
        } else{
            return this.tupleSchema.indexOf(attributeName);
        }
    }

    /**
     * Retrieves the Tuple schema
     * @return Tuple schema
     */
    public List<String> getTupleSchema() {
        return this.tupleSchema;
    }
}
