package ed.inf.adbs.lightdb.models;

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
     * Retrieves the value of a tuple at the specified index
     * @param index The index of the field to retrieve
     * @return The value of the field
     */
    public long getTupleField(int index) {
        return this.tuple[index];
    }

    /**
     * Retrieves the entire tuple
     * @return Tuple array
     */
    public long[] getTuple() {
        return this.tuple;
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
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * Retrieves the schema of a tuple field value
     * @param fieldValue The field value of the tuple
     * @return The corresponding column name
     */
    public long getFieldPositionByValue(String fieldValue) {
        if(Objects.equals(fieldValue, "*")){
            return -1;
        }
        return this.tupleSchema.indexOf(fieldValue);
    }

    /**
     * Retrieves the Tuple schema
     * @return Tuple schema
     */
    public List<String> getTupleSchema() {
        return this.tupleSchema;
    }

}
