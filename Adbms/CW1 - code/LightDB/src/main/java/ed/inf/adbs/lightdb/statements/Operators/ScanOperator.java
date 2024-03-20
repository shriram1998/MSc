package ed.inf.adbs.lightdb.statements.Operators;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import ed.inf.adbs.lightdb.models.Tuple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScanOperator extends Operator{
    private String tableName;
    private String tableFilePath;
    private BufferedReader reader;
    /**
     * Constructor class to initialize reader
     * @param table table name or alias
     */
    public ScanOperator(String table){
        tableName = table;
        tableFilePath=DatabaseCatalog.getTableFilePath(table);
        String dataFilePath = DatabaseCatalog.getTableFilePath(tableName);
        try{
            reader = new BufferedReader(new FileReader(dataFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Return the next tuple
     * @return next tuple
     */
    @Override
    public Tuple getNextTuple(){
        try{
            String line = reader.readLine();
            if (line == null) return null;
            String[] split = line.split(",");
            long[] values = new long[split.length];
            for (int i = 0; i < split.length; i++) {
                values[i] = Integer.parseInt(split[i].trim());
            }
//            System.out.println("Returning from scan"+ Arrays.toString(intArray));
            return new Tuple(values, DatabaseCatalog.getTableSchema(tableName));
        } catch (IOException e) {
            return null;
        }
    }
    /**
     * Reset the reader
     */
    @Override
    public void reset(){
        try{
            reader.close();
            reader = new BufferedReader(new FileReader(tableFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns table name (name or alias)
     * @return table name
     */
    public String getTableName() {

        return tableName;
    }
}
