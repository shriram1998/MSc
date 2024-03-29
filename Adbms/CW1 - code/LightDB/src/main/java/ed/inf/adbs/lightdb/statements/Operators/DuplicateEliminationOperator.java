package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Duplicate elimination operator class
 */
public class DuplicateEliminationOperator extends Operator {
    private Operator childOperator;
    private List<Tuple> tuples;

    /**
     * Duplicate Elimination Operator constructor
     * 
     * @param operator child operator
     * @param tuples   list of tuples (sorted)
     */
    public DuplicateEliminationOperator(Operator operator, List<Tuple> tuples) {
        this.childOperator = operator;
        this.tuples = tuples;
    }

    /**
     * Eliminate duplicates in a list of sorted tuples
     * 
     * @return list with sorted tuples without duplicates
     */
    public List<Tuple> getUniquetuples() {
        int lastDistinctTupleIndex = 0;
        if (this.tuples.isEmpty())
            return this.tuples;
        Tuple lastDistinctTuple = this.tuples.get(0);
        List<Tuple> distictTuples = new ArrayList<>();
        distictTuples.add(lastDistinctTuple);
        for (int i = 1; i < this.tuples.size(); i++) {
            Tuple currentTuple = this.tuples.get(i);
            lastDistinctTuple = distictTuples.get(lastDistinctTupleIndex);
            if (!Arrays.toString(currentTuple.getTuple()).equals(Arrays.toString(lastDistinctTuple.getTuple()))) {
                distictTuples.add(currentTuple);
                lastDistinctTupleIndex++;
            }
        }
        this.tuples = distictTuples;
        return this.tuples;
    }

    /**
     * Not used
     */
    @Override
    public Tuple getNextTuple() {
        return null;
    }

    /**
     * Not used
     */
    @Override
    public void reset() {
    }
}
