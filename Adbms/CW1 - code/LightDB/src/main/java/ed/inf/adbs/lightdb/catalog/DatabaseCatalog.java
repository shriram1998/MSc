package ed.inf.adbs.lightdb.catalog;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Singleton catalog class to store database schema, paths and data
 */
public class DatabaseCatalog {
    private static DatabaseCatalog catalogInstance=null;
    private static String dataDirectoryPath="";
    private static String schemaFilePath="";
    private static String outputFilePath="";
    private static HashMap<String, String> aliasMap = new HashMap<>();
    private static Map<String, TableSchema> tables=new HashMap<>();

    /**
     * Returns the Catalog instance, ensuring that there is only instance
     * @return DatabaseCatalog instance
     */
    public static DatabaseCatalog getInstance() {
        if (catalogInstance == null) {
            catalogInstance=new DatabaseCatalog();
        }
        return catalogInstance;
    }

    public void init(String dbDirectory, String outputDirectory){
        dataDirectoryPath = dbDirectory + File.separator + "data";
        schemaFilePath = dbDirectory + File.separator + "schema.txt";
        outputFilePath=outputDirectory;
        aliasMap=new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(schemaFilePath));
            String line;
            HashMap<String, Integer> columnMapping = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String tableName = parts[0];
                String[] columns = new String[parts.length - 1];
                for (int i = 1; i < parts.length; ++i)  {
                    columnMapping.put(tableName + "." + parts[i], i-1);
                    columns[i-1]=parts[i];
                }
                String dataFilePath = dataDirectoryPath + File.separator + tableName + ".csv";
                tables.put(tableName, new TableSchema(Arrays.asList(columns), dataFilePath, columnMapping));
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(""); //empty the output file
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns file path of a table or alias
     * @param table table name or alias
     * @return file path of the requested table
     */
    public static String getTableFilePath(String table) {
        if(!aliasMap.isEmpty() && aliasMap.containsKey(table)){
            String tableName=aliasMap.get(table);
            return tables.get(tableName).getDataFilePath();
        }else{
            return tables.get(table).getDataFilePath();
        }
    }

    /**
     * Returns schema of the table
     * @param table table name or alias
     * @return list of columns
     */
    public static List<String> getTableSchema(String table) {
        if(!aliasMap.isEmpty() && aliasMap.containsKey(table)){
            String tableName=aliasMap.get(table);
            List<String> plainColumns=tables.get(tableName).getColumns();
            return plainColumns.stream()
                    .map(s -> table+"."+s )
                    .collect(Collectors.toList()); //columns with table name alias Eg: S.A
        }else{
            return tables.get(table).getColumns().stream()
                    .map(s -> table+"."+s )
                    .collect(Collectors.toList()); //columns with table name Eg: Sailors.A
        }
    }

    /**
     * Returns the position of the column in the table based
     * on column mapping in the table schema
     * @param column Column name of the form Sailors.A or S.A
     * @return position of the column in the table
     */
    public static int getColumnPosition(String column) {
        if (Objects.equals(column, "*")){
            return -1;
        }
        String[] split = column.split("\\.");
        if(!aliasMap.isEmpty()){
            String tableName=aliasMap.get(split[0]);
            return tables.get(tableName).getColumnMapping().get(tableName+"."+split[1]);
        }else{
            return tables.get(split[0]).getColumnMapping().get(column);
        }
    }

    /**
     * Get output file path
     */
    public static String getOutputPath() {

        return outputFilePath;
    }

    /**
     * Get alias map
     */
    public static HashMap<String, String> getAliasMap() {

        return aliasMap;
    }

    /**
     * Initialize alias hashmap
     * @param aliasMap hashmap of alias
     */
    public static void setAliasMap(HashMap<String, String> aliasMap) {

        DatabaseCatalog.aliasMap = aliasMap;
    }

    /**
     * Inner class to encapsulate table schema and data file path
     */
    public class TableSchema {
        private List<String> columns;
        Map<String, Integer> columnMapping = new HashMap<>();
        private String dataFilePath;
        /**
         * Constructor to store table metadata to table schema instance
         */
        public TableSchema(List<String> columns, String dataFilePath, HashMap<String, Integer> columnPosition) {
            this.columns = columns;
            this.dataFilePath = dataFilePath;
            this.columnMapping=columnPosition;
        }
        /**
         * Returns list of the columns present in the corresponding schema instance
         * @return table columns
         */
        public List<String> getColumns() {
            return columns;
        }
        /**
         * Returns path where table data is present
         * @return data file path
         */
        public String getDataFilePath() {
            return dataFilePath;
        }
        /**
         * Returns mapping of columnn names to it's position
         * @return column mapping
         */
        public Map<String, Integer> getColumnMapping() {
            return columnMapping;
        }

    }
}
