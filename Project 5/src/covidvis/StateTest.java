package covidvis;

import student.TestCase;

/**
 * Tests State.
 * 
 * @author Kyle Hart (kylegh)
 * @version 2020.11.18
 * @author Joshua Sooknanan (Sjoshua9)
 */
public class StateTest extends TestCase {

    private State state;
    private SinglyLinkedList<EthnicityGroup> list;

    /**
     * Called before each test case.
     */
    public void setUp() {
        list = new SinglyLinkedList<EthnicityGroup>();

        list.add(new EthnicityGroup("1", 5, 25));
        list.add(new EthnicityGroup("2", 10, 25));
        list.add(new EthnicityGroup("3", 10, 20));
        list.add(new EthnicityGroup("4", 15, 30));
        list.add(new EthnicityGroup("5", 18, 20));

        state = new State("test", list);

    }


    /**
     * Tests the get methods.
     */
    public void testGet() {
        assertEquals("test", state.getName());
        assertEquals(list, state.getList());
    }


    /**
     * Tests sortCFR.
     */
    public void testSortCFR() {
        state.sortCFR();

        assertEquals(state.getList().toString(),
            "{3: 10 cases, 20.0% CFR, 5: 18 cases, 20.0% CFR, 1: 5 cases, "
                + "25.0% CFR, 2: 10 cases, 25.0% CFR, 4: 15 cases, 30.0% CFR}");
    }


    /**
     * Tests sortAlpha.
     */
    public void testSortAlpha() {
        state.sortAlpha();

        assertEquals(state.getList().toString(),
            "{1: 5 cases, 25.0% CFR, 2: 10 cases, 25.0% CFR, 3: 10 cases, "
                + "20.0% CFR, 4: 15 cases, 30.0% CFR, 5: 18 cases, 20.0% CFR}");
    }

    // TODO Add state equals methods.
}