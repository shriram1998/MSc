package ed.inf.adbs.lightdb.metadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private static Catalog instance = null;

    private final String dataDirectory;
    private final String schemaFile;

    private final Map<String, TableSchema> tables;

    // Private constructor to prevent direct instantiation
    private Catalog(String dbDirectory) {
        this.dataDirectory = dbDirectory + File.separator + "data";
        this.schemaFile = dbDirectory + File.separator + "schema.txt";
        tables = new HashMap<>();
        loadSchema();
    }

    // Initializes the Catalog with the database directory path
    public static synchronized void initialize(String dbDirectory) {
        if (instance == null) {
            instance = new Catalog(dbDirectory);
        }
    }

    // Returns the Catalog instance, ensuring it has been initialized
    public static Catalog getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Catalog has not been initialized.");
        }
        return instance;
    }

    // Loads the database schema from schema.txt
    private void loadSchema() {
        try (BufferedReader reader = new BufferedReader(new FileReader(schemaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String tableName = parts[0];
                String[] columns = new String[parts.length - 1];
                System.arraycopy(parts, 1, columns, 0, parts.length - 1);
                String dataFilePath = dataDirectory + File.separator + tableName + ".csv";
                tables.put(tableName, new TableSchema(tableName, columns, dataFilePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse schema file: " + schemaFile);
        }
    }

    // Retrieves schema information for a specific table
    public TableSchema getTableSchema(String tableName) {
        return tables.get(tableName);
    }

    public Map<String, Integer> getColumnMapping(String tableName) {
        TableSchema schema = tables.get(tableName);
        if (schema == null) {
            throw new IllegalArgumentException("Table " + tableName + " does not exist in the catalog.");
        }

        Map<String, Integer> columnMapping = new HashMap<>();
        List<String> columnNames = List.of(schema.columns);
        for (int i = 0; i < columnNames.size(); i++) {
            columnMapping.put(columnNames.get(i), i);
        }
        return columnMapping;
    }

    public String getTableFilePath(String tableName) {
        TableSchema schema = tables.get(tableName);
        return schema != null ? schema.getDataFilePath() : null;
    }

    // Inner class to encapsulate table schema and data file path
    public static class TableSchema {
        private final String tableName;
        private final String[] columns;
        private final String dataFilePath;

        public TableSchema(String tableName, String[] columns, String dataFilePath) {
            this.tableName = tableName;
            this.columns = columns;
            this.dataFilePath = dataFilePath;
        }

        public String getTableName() {
            return tableName;
        }

        public String[] getColumns() {
            return columns;
        }

        public String getDataFilePath() {
            return dataFilePath;
        }
    }
}