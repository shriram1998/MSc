package ed.inf.adbs.lightdb;

import java.io.FileNotFoundException;
import java.io.FileReader;

import ed.inf.adbs.lightdb.catalog.DatabaseCatalog;
import ed.inf.adbs.lightdb.statements.SelectStatement;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;

/**
 * Lightweight in-memory database system
 *
 */
public class LightDB {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Usage: LightDB database_dir input_file output_file");
			return;
		}

		String databaseDir = args[0];
		String inputFile = args[1];
		String outputFile = args[2];

		// Just for demonstration, replace this function call with your logic
		parseAndExecuteQuery(databaseDir, inputFile, outputFile);
	}

	/**
	 * Parses the query using JSQLParser, instantiates the database catalog,
	 * generate relational algebra query plan, executes the query in input file path
	 * and saves the results to the output file path
	 * @param dataDirectoryPath Path of the data
	 * @param inputFilePath Path to input file
	 * @param outputFilePath Path to output file
	 */
	public static void parseAndExecuteQuery (String dataDirectoryPath, String inputFilePath, String outputFilePath) {
		try {
			Statement statement = CCJSqlParserUtil.parse(new FileReader(inputFilePath));
			DatabaseCatalog catalog = DatabaseCatalog.getInstance();
			catalog.init(dataDirectoryPath, outputFilePath);
			if (statement != null) {
				PlainSelect select=(PlainSelect) statement;
				SelectStatement selectStatement=new SelectStatement(select);
				selectStatement.executeQuery();
			}
		} catch (JSQLParserException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
