package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import covidvis.Calculator;
import covidvis.GUIWindow;
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
     * 
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String file1 = "";
        // file1 = args[0];
        file1 = "Cases_and_Deaths_by_race_CRDT_Sep2020.csv";
        InputReader reader = new InputReader(file1);
        State[] states = reader.getStates();
        Calculator calc = new Calculator(states);
        for (int i = 0; i < states.length; i++) {
            System.out.println(states[i].toString());
        }
        new GUIWindow(calc);
    }
}
