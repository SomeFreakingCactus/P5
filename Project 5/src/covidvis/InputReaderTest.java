package covidvis;

import student.TestCase;

public class InputReaderTest extends TestCase {

	/**
	 * test InputReader when file exists and is correctly
	 * formatted
	 */
	public void testInputReader1()
	{
		Exception exception = null;
		try {
			new InputReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
			
		}
		catch (Exception e) {
			exception = e;
			
		}
		assertNull(exception);
	}

}
