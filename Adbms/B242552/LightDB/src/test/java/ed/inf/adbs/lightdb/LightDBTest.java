package ed.inf.adbs.lightdb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/**
 * Unit tests for LightDB.
 */
public class LightDBTest {
	/**
	 * Run all queries
	 */
	@Test
	public void executeQueries() {
		// Loop from query 1 to query 12
		for (int i = 1; i <= 12; i++) {
			String dbPath = "samples/db";
			String inputPath = String.format("samples/input/query%d.sql", i);
			String outputPath = String.format("samples/output/query%d.csv", i);
			String[] args = {dbPath, inputPath, outputPath};

			LightDB.main(args); // Execute the main class with arguments

			String expectedOutputPath = String.format("samples/expected_output/query%d.csv", i);

			assertFilesEqual(outputPath, expectedOutputPath);
		}
	}
	// Method to compare two CSV files
	private void assertFilesEqual(String actualPath, String expectedPath){
		try{
			List<String> actualLines = Files.readAllLines(Paths.get(actualPath));
			List<String> expectedLines = Files.readAllLines(Paths.get(expectedPath));

			assertEquals("The files " + actualPath + " and " + expectedPath + " do not match.", expectedLines, actualLines);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
