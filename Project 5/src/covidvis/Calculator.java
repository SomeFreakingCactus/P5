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
     * 
     * @author Kyle Hart (kylegh)
     * @return List of States
     */
    public State[] states() {
        return states;
    }


    /**
     * Returns the state at the given index.
     * 
     * @param index
     *            The index for the State
     * 
     * @author Kyle Hart (kylegh)
     * @return Specific state
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
