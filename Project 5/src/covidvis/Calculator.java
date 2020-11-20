package covidvis;

/**
 * Preforms all calculations
 * 
 * @author Kyle Hart (kylegh)
 * @version 2020.11.13
 */
public class Calculator {
    private State[] states;

    /**
     * Constructor.
     * 
     * @param states
     *            An array of all the states.
     * 
     * @author Kyle Hart (kylegh)
     */
    public Calculator(State[] states) {
        this.states = states;
    }


    /**
     * Returns the array of states.
     * TODO Remove this unnecessary function?
     * 
     * @author Kyle Hart (kylegh)
     */
    public State[] states() {
        return states;
    }


    /**
     * Returns the state at the given index.
     * 
     * @author Kyle Hart (kylegh)
     * 
     *         TODO Should the index start at 0 or 1?
     */
    public State getStateByIndex(int index) {
        return states[index];
    }


    /**
     * Sorts all ethnicity groups in all states by alphabetical order.
     * 
     * @author Kyle Hart (kylegh)
     */
    public void sortAlpha() {
        for (int i = 0; i < states.length; i++) {
            states[i].sortAlpha();
        }
    }


    /**
     * Sorts all ethnicity groups in all states by CFR.
     * 
     * @author Kyle Hart (kylegh)
     */
    public void sortCFR() {
        for (int i = 0; i < states.length; i++) {
            states[i].sortCFR();
        }
    }
}
