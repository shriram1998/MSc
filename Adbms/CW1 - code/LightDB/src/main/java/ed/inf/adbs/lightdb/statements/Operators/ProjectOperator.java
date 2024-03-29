package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Project operator class that projects the desired attributes given in the
 * query
 * from tuples return from the child operators Scan or Select.
 */
public class ProjectOperator extends Operator {
    private Operator childOperator;
    private List<String> attributes;
    private List<Tuple> allTuples = new ArrayList<>();

    /**
     * ProjectOperator constructor
     * 
     * @param operator    Child operator
     * @param selectItems list of project attributes
     */
    public ProjectOperator(Operator operator, List<String> selectItems) {
        this.childOperator = operator;
        this.attributes = selectItems;
    }

    /**
     * ProjectOperator constructor is all tuples are present already. Eg: Projection
     * after sum aggregate
     * 
     * @param allTuples   all tuples of Child operator
     * @param selectItems list of project attributes
     */
    public ProjectOperator(List<Tuple> allTuples, List<String> selectItems) {
        this.attributes = selectItems;
        List<String> updatedTupleSchema = new ArrayList<>(); // stores the names of desired attributes
        List<Integer> selectedIndices = new ArrayList<>(); // stores the indices of desired attributes in the tuple
        if (allTuples.isEmpty())
            return;
        for (String attribute : this.attributes) {
            if (!attribute.contains("SUM")) {
                selectedIndices.add(allTuples.get(0).getAttributeIndex(attribute));
                updatedTupleSchema.add(attribute);
            } else {
                selectedIndices.add(-1);
                updatedTupleSchema.add("sum");
            }
        }
        for (Tuple tuple : allTuples) {
            // * check not needed since the projection happens after a blocking group by
            int[] updatedTuple = new int[updatedTupleSchema.size()];
            for (int i = 0; i < updatedTupleSchema.size(); i++) {
                if (selectedIndices.get(i) != -1) {
                    updatedTuple[i] = tuple.getTupleField(selectedIndices.get(i));
                } else {
                    // if the index is not that of a column
                    if (updatedTupleSchema.get(i).equals("sum")) {
                        updatedTuple[i] = tuple.getTupleField(tuple.getAttributeIndex("sum"));
                    }
                }
            }
            this.allTuples.add(new Tuple(updatedTuple, updatedTupleSchema));
        }
    }

    /**
     * Returns all the tuples projection
     */
    public List<Tuple> getAllProjectedTuples() {
        return this.allTuples;
    }

    /**
     * Return the next tuple with desired attributes in the query
     * 
     * @return next tuple with desired attributes
     */
    @Override
    public Tuple getNextTuple() {
        Tuple tuple = this.childOperator.getNextTuple();
        if (tuple == null)
            return null;
        List<String> updatedTupleSchema = new ArrayList<>(); // stores the names of desired attributes
        List<Integer> selectedIndices = new ArrayList<>(); // stores the indices of desired attributes in the tuple
        for (String attribute : this.attributes) {
            if (!attribute.contains("SUM")) {
                selectedIndices.add(tuple.getAttributeIndex(attribute));
                updatedTupleSchema.add(attribute);
            } else {
                selectedIndices.add(-1);
                updatedTupleSchema.add("sum");
            }

        }
        if (selectedIndices.get(0).toString().equals("-1")) {
            return tuple;
        } else {
            int[] updatedTuple = new int[updatedTupleSchema.size()];
            for (int i = 0; i < updatedTupleSchema.size(); i++) {
                if (selectedIndices.get(i) != -1) {
                    updatedTuple[i] = tuple.getTupleField(selectedIndices.get(i));
                } else {
                    // if the index is not that of a column
                    if (updatedTupleSchema.get(i).contains("SUM")) {
                        updatedTuple[i] = tuple.getTupleField(tuple.getAttributeIndex("sum"));
                    }
                }
            }
            return new Tuple(updatedTuple, updatedTupleSchema);
        }
    }

    /**
     * Calls the child operator's reset method
     */
    @Override
    public void reset() {
        this.childOperator.reset();
    }
}
