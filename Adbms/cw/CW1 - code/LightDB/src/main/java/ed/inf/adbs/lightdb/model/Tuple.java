package ed.inf.adbs.lightdb.model;

import java.util.Arrays;

/**
 * Represents a tuple in the LightDB system.
 * A tuple corresponds to a row of data in a table.
 */
public class Tuple {
    private final Object[] fields;

    /**
     * Constructs a tuple with the specified fields.
     * @param fields The fields of the tuple.
     */
    public Tuple(Object... fields) {
        this.fields = fields;
    }

    /**
     * Retrieves the value of a field at the specified index.
     * @param index The index of the field to retrieve.
     * @return The value of the field.
     */
    public Object getField(int index) {
        return fields[index];
    }

    /**
     * Returns a string representation of the tuple.
     * @return A string representation of the tuple.
     */
    @Override
    public String toString() {
        return "Tuple{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }
}