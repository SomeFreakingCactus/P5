package covidvis;

/**
 * State object
 * 
 * @author Kyle Hart (kylegh
 * @version 2020.11.13
 */
public class State {
    private SinglyLinkedList<EthnicityGroup> population;

    public State() {
        // TODO Auto-generated constructor stub
    }


    /**
     * Sorts the state's ethnicity groups by CFR with selection sort.
     * 
     * @author Kyle Hart (kylegh)
     */
    public void sortCFR() {
        /*
         * TODO Come up with a better way of sorting this. This is horribly
         * inefficient and will almost certainly get points taken off. But it
         * should get the job done. Maybe we can move the sorting to
         * SinglyLinkedList somehow?
         */
        EthnicityGroup current = population.get(0);
        // TODO Should this be largest or smallest?
        EthnicityGroup largest = current;
        int currentIndex = 0;

        for (int i = 0; i < population.size(); i++) {
            for (int j = i; j < population.size(); j++) {
                current = population.get(j);
                // TODO Is this sign in the right sign direction?
                if (current.toString().compareTo(largest.toString()) > 0) {
                    largest = current;
                    currentIndex = j;
                }
                population.remove(largest);
                population.add(largest);
            }
        }
        // TODO instantiate default case, or at least specify @precon.
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
        EthnicityGroup current = population.get(0);
        // TODO Should this be largest or smallest?
        EthnicityGroup largest = current;
        int currentIndex = 0;

        for (int i = 0; i < population.size(); i++) {
            for (int j = i; j < population.size(); j++) {
                current = population.get(j);
                // TODO Is this sign in the right sign direction?
                if (current.compareCFR(largest) > 0) {
                    largest = current;
                    currentIndex = j;
                }
                population.remove(largest);
                population.add(largest);
            }
        }
        // TODO instantiate default case, or at least specify @precon.
    }

}
