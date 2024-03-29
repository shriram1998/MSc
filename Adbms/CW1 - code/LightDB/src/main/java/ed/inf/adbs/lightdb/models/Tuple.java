package ed.inf.adbs.lightdb.models;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;

import java.util.*;

/**
 * Represents a tuple in the LightDB system
 * A tuple corresponds to a row of data in a table
 * Implements methods to handle tuple array and metadata of tuple that is Column names
 */
public class Tuple {
    private final int[] tuple;
    private final List<String> tupleSchema;

    /**
     * Constructs a tuple with the specified fields
     * @param fields The fields of the tuple
     * @param schema The schema of the tuple
     */
    public Tuple(int[] fields, List<String> schema) {
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
        this.tuple = new int[leftTupleSize+rightTuple.getSize()];
        for(int i=0;i<this.tuple.length;i++){
            if(i<leftTupleSize){ //fill the left tuple fields in the result tuple
                this.tuple[i]=leftTuple.getTupleField(i);
            } else{
                this.tuple[i]= rightTuple.getTupleField(i-leftTupleSize);
            }
        }
        //create new schema which is a combination of left and right tuple schema
        this.tupleSchema=new ArrayList<>(leftTuple.getTupleSchema());
        this.tupleSchema.addAll(rightTuple.getTupleSchema());
    }

    /**
     * Returns the tuple
     *
     * @return tuple
     */
    public int[] getTuple() {
        return this.tuple;
    }

    /**
     * Retrieves the value of a tuple at the specified index
     * @param index The index of the field to retrieve
     * @return The value of the field
     */
    public int getTupleField(int index) {
        return this.tuple[index];
    }

    /**
     * Returns size of the tuple
     * @return tuple size
     */
    public int getSize() {
        return this.tuple.length;
    }

    /**
     * Returns a string representation of the tuple
     * @return A string representation of the tuple
     */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<this.tuple.length;i++){
            sb.append(this.tuple[i]);
            if(i!=this.tuple.length-1){
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
            String[] split=attributeName.split("\\.");
            HashMap<String, String> aliasMap = DatabaseCatalog.getAliasMap();
            if(!aliasMap.isEmpty()){
                String tableName=aliasMap.get(split[0]);
                return this.tupleSchema.indexOf(tableName+"."+split[1]);
            }else{
                return this.tupleSchema.indexOf(attributeName);
            }
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
