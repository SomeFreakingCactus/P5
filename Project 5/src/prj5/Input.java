package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;

import covidvis.InputReader;
import covidvis.State;

/**
 * Class that runs main program
 */
public class Input {

    /**
     * Create a new Input object.
     */
    public Input() {
        // This method is intentionally empty
    }

    /**
     * Main code output
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
    	String file1 = "";
        file1 = args[0];
        InputReader reader = new InputReader(file1);
        State[] states = reader.getStates();
        
        for (int i = 0; i < states.length; i++) {
        	System.out.println(states[i].toString());
        }
    }
}
