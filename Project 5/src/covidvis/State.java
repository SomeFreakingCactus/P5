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
     */
    public void sortCFR() {
        EthnicityGroup current;
        EthnicityGroup smallest;

        for (int i = population.size() - 1; i >= 0; i--) {
            smallest = population.get(i);
            for (int j = i - 1; j >= 0; j--) {
                current = population.get(j);

                if (smallest.compareCFR(current) >= 0) {
                    smallest = current;
                }
            }
            population.remove(smallest);
            population.add(smallest);
        }
    }


    /**
     * Sorts the state's ethnicity groups by name with selection sort.
     * 
     * @author Kyle Hart (kylegh)
     */
    public void sortAlpha() {
        EthnicityGroup current;
        EthnicityGroup smallest;

        for (int i = population.size() - 1; i >= 0; i--) {
            smallest = population.get(i);
            for (int j = i - 1; j >= 0; j--) {
                current = population.get(j);

                if (smallest.toString().compareTo(current.toString()) > 0) {
                    smallest = current;
                }
            }
            population.remove(smallest);
            population.add(smallest);
        }
    }

}
