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
	 * @param name name of State
	 * @param pop  population of state
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
		for (int i = 0; i < population.size(); i++)
		{
			sb.append(population.get(i).toString());
			sb.append("\n");
		}
		sb.append("=====");
		sb.append("\n");
		this.sortCFR();
		for (int i = 0; i < population.size(); i++)
		{
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
        /*
         * TODO Come up with a better way of sorting this. This is horribly
         * inefficient and will almost certainly get points taken off. But it
         * should get the job done. Maybe we can move the sorting to
         * SinglyLinkedList somehow?
         */
        EthnicityGroup current;
        EthnicityGroup smallest;
        int size = population.size();
        int temp;

        for (int i = size - 1; i >= 0; i--) {
            smallest = population.get(i);
            for (int j = i - 1; j >= 0; j--) {
                current = population.get(j);
                temp = smallest.compareCFR(current);

                if (temp >= 0) {
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
        /*
         * TODO Come up with a better way of sorting this. This is horribly
         * inefficient and will almost certainly get points taken off. But it
         * should get the job done. Maybe we can move the sorting to
         * SinglyLinkedList somehow?
         */
        EthnicityGroup current;
        EthnicityGroup smallest;
        int size = population.size();
        int temp;

        for (int i = size - 1; i >= 0; i--) {
            smallest = population.get(i);
            for (int j = i - 1; j >= 0; j--) {
                current = population.get(j);
                temp = smallest.toString().compareTo(current.toString());

                if (temp > 0) {
                    smallest = current;
                }
            }
            population.remove(smallest);
            population.add(smallest);
        }
    }

}
