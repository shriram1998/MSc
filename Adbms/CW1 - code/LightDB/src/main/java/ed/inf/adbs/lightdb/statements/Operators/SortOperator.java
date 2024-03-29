package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import net.sf.jsqlparser.statement.select.OrderByElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sort operator class
 */
public class SortOperator extends Operator {
    private Operator childOperator;
    private List<Tuple> allTuples;
    private List<Integer> orderByIndices = new ArrayList<>();

    /**
     * SortOperator constructor
     * 
     * @param operator       child operator
     * @param orderByElement list with attributes of order by
     */
    public SortOperator(Operator operator, List<OrderByElement> orderByElement) {
        this.childOperator = operator;
        this.allTuples = childOperator.getAllTuples();
        // get tuple schema if there is atleast one tuple returned by child operator
        if (this.allTuples.isEmpty())
            return;
        List<String> tupleSchema = this.allTuples.get(0).getTupleSchema();
        if (orderByElement != null) {
            for (OrderByElement element : orderByElement) {
                this.orderByIndices.add(tupleSchema.indexOf(element.toString()));
            }
        } else {
            /*
             * Sorting without orderby which is used for duplicate elimination
             */
            int tupleSize = this.allTuples.get(0).getSize();
            for (int i = 0; i < tupleSize; i++) {
                this.orderByIndices.add(i);
            }
        }
        /*
         * List.sort() might be marginally faster due to it being a direct call on the
         * list object without the extra step of the Collections.sort() method call.
         */
        this.allTuples.sort(new TupleComparator()); // sort the tuples according to the TupleComparator
    }

    /**
     * SortOperator constructor for sorting after sum aggregation where all tuples
     * are available
     * 
     * @param allTuples      all the child tuples
     * @param orderByElement list with attributes of order by
     */
    public SortOperator(List<Tuple> allTuples, List<OrderByElement> orderByElement) {
        this.allTuples = allTuples;
        // get tuple schema if there is atleast one tuple returned by child operator
        if (this.allTuples.isEmpty())
            return;
        List<String> tupleSchema = this.allTuples.get(0).getTupleSchema();
        if (orderByElement != null) {
            for (OrderByElement element : orderByElement) {
                this.orderByIndices.add(tupleSchema.indexOf(element.toString()));
            }
        } else {
            /*
             * Sorting without orderby which is used for duplicate elimination
             */
            int tupleSize = this.allTuples.get(0).getSize();
            for (int i = 0; i < tupleSize; i++) {
                this.orderByIndices.add(i);
            }
        }
        /*
         * List.sort() might be marginally faster due to it being a direct call on the
         * list object without the extra step of the Collections.sort() method call.
         */
        allTuples.sort(new TupleComparator()); // sort the tuples according to the TupleComparator
    }

    /**
     * Custom tuple comparator
     */
    private class TupleComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple tuple1, Tuple tuple2) {
            /*
             * based on order by priority compare two tuples
             */
            for (Integer ord : orderByIndices) {
                int value1 = tuple1.getTupleField(ord);
                int value2 = tuple2.getTupleField(ord);
                int result = Integer.compare(value1, value2);
                if (result != 0)
                    return result;
            }
            return 0; // if all order by fields are equal
        }
    }

    /**
     * Returns all the tuples sorted using order by clause
     */
    public List<Tuple> getSortedTuples() {
        return this.allTuples;
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
