package ed.inf.adbs.lightdb.core.executor.operators;

import ed.inf.adbs.lightdb.metadata.Catalog;
import ed.inf.adbs.lightdb.model.Tuple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScanOperator extends Operator {
    private final String tableName;
    private BufferedReader reader;

    public ScanOperator(String tableName) throws IOException {
        this.tableName = tableName;
        initializeReader();
    }

    private void initializeReader() throws IOException {
        // Assuming a Catalog class exists that can provide the file path for a table name
        String dataFilePath = Catalog.getInstance().getTableFilePath(tableName);
        this.reader = new BufferedReader(new FileReader(dataFilePath));
    }

    @Override
    public Tuple getNextTuple() throws IOException {
        String line = reader.readLine();
        if (line != null) {
            // Assuming a Tuple class exists that can parse a line of text into a tuple
            return new Tuple(line);
        }
        return null; // End of file reached
    }

    @Override
    public void reset() throws IOException {
        reader.close(); // Close the current reader
        initializeReader(); // Re-initialize to start from the beginning of the file
    }

    // Implement other necessary methods as required by the abstract Operator class
}