package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import net.sf.jsqlparser.statement.select.OrderByElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Select operator class
 */
public class SortOperator {
    private Operator childOperator;
    private List<Tuple> allTuples;
    private List<Integer> orderByIndices=new ArrayList<>();
    /**
     * SortOperator constructor
     * @param operator child operator
     * @param orderByElement list with attributes of order by
     */
    public SortOperator(Operator operator, List<OrderByElement> orderByElement) {
        childOperator=operator;
        allTuples=childOperator.getAllTuples();
        //get tuple schema if there is atleast one tuple returned by child operator
        if(allTuples.isEmpty()) return;
        List<String> tupleSchema=allTuples.get(0).getTupleSchema();
        if(orderByElement!=null){
            for(OrderByElement element:orderByElement){
                orderByIndices.add(tupleSchema.indexOf(element.toString()));
            }
        } else{

        }
    }
}
