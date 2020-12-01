package covidvis;

/**
 * Represents each state which holds a population of different ethnicity groups
 * 
 * @author Kyle Hart (kylegh)
 * @version 2020.11.18
 * @author Joshua Sooknanan Sjoshua9)
 * @version 2020.11.15
 */
public class State {

    private SinglyLinkedList<EthnicityGroup> population;
    private String stateName;

    /**
     * Creates a new State object
     * 
     * @param name
     *            name of State
     * @param pop
     *            population of state
     */
    public State(String name, SinglyLinkedList<EthnicityGroup> pop) {
        stateName = name;
        population = pop;
    }


    /**
     * Returns name of State
     * 
     * @return name of State
     */
    public String getName() {
        return stateName;
    }


    /**
     * Returns list of ethnicity groups in state
     * 
     * @return The ethnicity groups of the state.
     */
    public SinglyLinkedList<EthnicityGroup> getList() {
        return population;
    }


    /**
     * Turns State's population into a string
     * 
     * @return The State in a string
     */
    public String toString() {
        this.sortAlpha();
        StringBuilder sb = new StringBuilder();
        sb.append("" + this.getName());
        sb.append("\n");
        for (int i = 0; i < population.size(); i++) {
            sb.append(population.get(i).toString());
            sb.append("\n");
        }
        sb.append("=====");
        sb.append("\n");
        this.sortCFR();
        for (int i = 0; i < population.size(); i++) {
            sb.append(population.get(i).toString());
            sb.append("\n");
        }
        sb.append("=====");
        return sb.toString();
    }


    /**
     * Sorts the state's ethnicity groups by CFR with selection sort.
     * 
     * @author Kyle Hart (kylegh)
     * @author Joshua Sooknanan (Sjoshua9)
     */
    public void sortCFR() {
        int size = population.size();
        if (population.size() > 1) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size - 1; i++) {
                    // in the case of a tie
                    if (population.get(i).compareCFR(population.get(i
                        + 1)) == 0) {
                        if (population.get(i).compareName(population.get(i
                            + 1)) > 0) {
                            EthnicityGroup small = population.get(i + 1);
                            population.remove(i + 1);
                            population.add(i, small);
                        }
                    }
                    if (population.get(i).compareCFR(population.get(i
                        + 1)) < 0) {
                        EthnicityGroup small = population.get(i + 1);
                        population.remove(i + 1);
                        population.add(i, small);
                    }
                }
            }
        }
    }


    /**
     * Sorts the state's ethnicity groups by name with selection sort.
     * 
     * @author Kyle Hart (kylegh)
     * @author Joshua Sooknanan (Sjoshua9)
     */
    public void sortAlpha() {
        int size = population.size();
        if (size > 1) {
            for (int j = 0; j < population.size(); j++) {
                for (int i = 0; i < size - 1; i++) {
                    if (population.get(i).compareName(population.get(i
                        + 1)) > 0) {
                        EthnicityGroup small = population.get(i + 1);
                        population.remove(i + 1);
                        population.add(i, small);
                    }
                }
            }
        }
    }

}
