package covidvis;

import student.TestCase;

/**
 * Tests State.
 * 
 * @author Kyle Hart (kylegh
 * @version 2020.11.18
 */
public class StateTest extends TestCase {

    private State state;
    private SinglyLinkedList<EthnicityGroup> list;
    
    /**
     * Called before each test case.
     */
    public void setUp() {
        SinglyLinkedList<EthnicityGroup> list = new SinglyLinkedList<EthnicityGroup>();
        list.add(new EthnicityGroup("1", 5, 25));
        list.add(new EthnicityGroup("2", 10, 25));
        list.add(new EthnicityGroup("3", 10, 20));
        list.add(new EthnicityGroup("4", 15, 30));
        list.add(new EthnicityGroup("5", 20, 20));
        
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
     * Tests the sortCFR.
     */
    public void testSortCFR() {
        
    }
}
