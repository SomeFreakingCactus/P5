package covidvis;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Reads and parses input
 * @author Joshua Sooknanan
 * @version 2020.11.18
 *
 */
public class InputReader {
	private State[] states;

	public InputReader(String covidFile) throws FileNotFoundException, ParseException {
		this.readFile(covidFile);
	}

	/**
	 * 
	 * @param fileName
	 * 		name of File
	 * @return
	 * 		array of states
	 * @throws FileNotFoundException
	 * 		throws when file is not found
	 * @throws ParseException
	 * 		throws when not enough attributes in line
	 */
	private State[] readFile(String fileName) throws FileNotFoundException, ParseException {
		states = new State[6];
		Scanner file = new Scanner(new File(fileName));
		int index = 0;
		// reading past first line
		file.nextLine();
		
		while (file.hasNextLine()) {
			String line = file.nextLine();
			line = line.replace("NA", "-1");
			String[] lineArray = line.split(",");

			if (lineArray.length != 11) {
				throw new ParseException(line, lineArray.length);
			}
			// parsing
			String stateName = lineArray[0];
			int casesWh = Integer.parseInt(lineArray[1]);
			int casesBl = Integer.parseInt(lineArray[2]);
			int casesLat = Integer.parseInt(lineArray[3]);
			int casesAsi = Integer.parseInt(lineArray[4]);
			int casesOth = Integer.parseInt(lineArray[5]);
			
			double deathWh = Integer.parseInt(lineArray[6]);
			double deathBl = Integer.parseInt(lineArray[7]);
			double deathLat = Integer.parseInt(lineArray[8]);
			double deathAsi = Integer.parseInt(lineArray[9]);
			double deathOth = Integer.parseInt(lineArray[10]);

			// calc cfr
			double cfrWh = (deathWh / ((double)casesWh)) * 100;
			double cfrBl = (deathBl / ((double)casesBl)) * 100;
			double cfrLat = (deathLat / ((double)casesLat)) * 100;
			double cfrAsi = (deathAsi / ((double)casesAsi)) * 100;
			double cfrOth = (deathOth / ((double)casesOth)) * 100;
			
			if (deathWh == -1) {
				cfrWh = -1;
			}
			if (deathBl == -1) {
				cfrBl = -1;
			}
			if (deathLat == -1) {
				cfrLat = -1;
			}
			if (deathAsi == -1) {
				cfrAsi = -1;
			}
			if (deathOth == -1) {
				cfrOth = -1;
			}

			// creating state object
			EthnicityGroup white = new EthnicityGroup("White", casesWh, cfrWh);
			EthnicityGroup black = new EthnicityGroup("Black", casesBl, cfrBl);
			EthnicityGroup latin = new EthnicityGroup("Latinx", casesLat, cfrLat);
			EthnicityGroup asian = new EthnicityGroup("Asian", casesAsi, cfrAsi);
			EthnicityGroup other = new EthnicityGroup("Other", casesOth, cfrOth);
			SinglyLinkedList<EthnicityGroup> pop = new SinglyLinkedList<EthnicityGroup>();
			pop.add(white);
			pop.add(black);
			pop.add(latin);
			pop.add(asian);
			pop.add(other);

			State state = new State(stateName, pop);
			states[index] = state;
			index++;

		}
		return states;

	}
	
	/**
	 * Get array of States
	 * @return
	 * 		Array of States
	 */
	public State[] getStates()
	{
		return states;
	}
}
