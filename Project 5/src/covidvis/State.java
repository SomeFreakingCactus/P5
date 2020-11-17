package covidvis;

/**
 * State object
 * 
 * @author Kyle Hart (kylegh)
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
        int size = population.size();

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                current = population.get(j);
                // TODO Is this sign in the right direction?
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
        int size = population.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                current = population.get(j); // O(n)
                // TODO Is this sign in the right direction?
                if (current.compareCFR(largest) > 0) {
                    largest = current;
                    currentIndex = j;
                } // O(n-1)
                population.remove(largest); // <=O(n)
                population.add(largest); // O(1)
            } // O(n * (3n))
        } // O((n-1) * n * (3n))
          // TODO instantiate default case, or at least specify @precon.
          // O(3n^3 - 3n^2) at list level. AKA remarkably inefficient.
    }

}
