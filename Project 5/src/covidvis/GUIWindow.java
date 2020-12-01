package covidvis;

import cs2.Button;
import cs2.TextShape;
import cs2.Window;

/**
 * Visualizes the COVID-19 testing data in a new window.
 * 
 * @author all
 * @version 2020.11.30
 */
public class GUIWindow {
    private Window window;
    private Calculator calc;
    private Button alpha;
    private Button cfr;
    private Button quit;
    private Button[] stateButtons;

    /**
     * Display Window
     */
    public GUIWindow() {
        // Nothing done yet
    }

    // TODO Figure out a way to implement clickedState without an int parameter.


    public void clickedAlpha(Button alpha) {
        // TODO
    }


    public void clickedCfr(Button cfr) {
        // TODO
    }


    private void displayState(int index) {
        int xPos = 50 + 80*index;
        int yPos = 20;
        State state = calc.getStateByIndex(index);
        TextShape text = new TextShape(0,0,state.getName());
    }


    private void displayBar(EthnicityGroup group, int pos) {
        // TODO
    }
}
