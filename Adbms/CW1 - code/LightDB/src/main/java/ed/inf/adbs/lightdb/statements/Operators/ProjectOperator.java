package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.models.Tuple;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Project operator class that projects the desired attributes given in the query
 * from tuples return from the child operators Scan or Select.
 */
public class ProjectOperator extends Operator{
    private Operator childOperator;
    private List<SelectItem<?>> attributes;
    /**
     * ProjectOperator constructor
     * @param operator Child operator
     * @param selectItems list of project attributes
     */
    public ProjectOperator(Operator operator, List<SelectItem<?>> selectItems) {
        this.childOperator=operator;
        this.attributes=selectItems;
    }

    /**
     * Return the next tuple with desired attributes in the query
     * @return next tuple with desired attributes
     */
    @Override
    public Tuple getNextTuple(){
        Tuple tuple = childOperator.getNextTuple();
        if (tuple == null) return null;
        List<String> updatedTupleSchema=new ArrayList<>(); //stores the names of desired attributes
        List<Integer> selectedIndices=new ArrayList<>(); //stores the indices of desired attributes in the tuple
        for(SelectItem<?> attribute:attributes){
            selectedIndices.add(tuple.getAttributeIndex(attribute.toString()));
            updatedTupleSchema.add(attribute.toString());
        }
        if(selectedIndices.get(0).toString().equals("-1")){
            return tuple;
        }else{
            long[] updatedTuple=new long[attributes.size()];
            for(int i=0;i<attributes.size();i++){
                updatedTuple[i]=tuple.getTupleField(selectedIndices.get(i));
            }
            return new Tuple(updatedTuple,updatedTupleSchema);
        }
    }
    /**
     * Calls the child operator's reset method
     */
    @Override
    public void reset() {
        childOperator.reset();
    }
}
