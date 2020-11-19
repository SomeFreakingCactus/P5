package covidvis;

/**
 * Test class for State class
 * 
 * @author Joshua Sooknanan
 * @version 2020.11.18
 *
 */
public class StateTest extends student.TestCase {
	private State state;
	private SinglyLinkedList<EthnicityGroup> pop;
	private EthnicityGroup white;
	private EthnicityGroup black;
	private EthnicityGroup asian;

	/**
	 * Set up thats is ran prior to every test
	 */
	public void setUp() {
		white = new EthnicityGroup("White", 3000, 0.4);
		black = new EthnicityGroup("Black", 4000, 0.3);
		asian = new EthnicityGroup("Asian", 5000, 0.2);
		pop = new SinglyLinkedList<EthnicityGroup>();
		pop.add(asian);
		pop.add(white);
		pop.add(black);
		state = new State("VA", pop);
	}
	
	/**
	 * test getName
	 */
	public void testGetName()
	{
		assertEquals("VA", state.getName());
	}
	
	/**
	 * test getList
	 */
	public void testGetList()
	{
		assertEquals(pop, state.getList());
	}
	
	/**
	 * test sortCFR when population is greater than 1
	 */
	public void testSortCFRT()
	{
		state.sortCFR();
		assertEquals(white, state.getList().get(0));
	}
	
	/**
	 * test sortCFR when population is only 1
	 */
	public void testSortCFR1()
	{
		SinglyLinkedList<EthnicityGroup> pop2 = new SinglyLinkedList<EthnicityGroup>();
		pop2.add(black);
		State state2 = new State("NE", pop2);
		state2.sortCFR();
		assertEquals(black, state2.getList().get(0));
	}
	
	/**
	 * test sortAlpha when population is greater than 1
	 */
	public void testSortAlphaT()
	{
		state.sortAlpha();
		assertEquals(asian, state.getList().get(0));
	}
	
	/**
	 * test sortAlpha when population is only 1
	 */
	public void testSortAlpha()
	{
		SinglyLinkedList<EthnicityGroup> pop2 = new SinglyLinkedList<EthnicityGroup>();
		pop2.add(black);
		State state2 = new State("NE", pop2);
		state2.sortAlpha();
		assertEquals(black, state2.getList().get(0));
	}
	
	/**
	 * test ToString checking formatting
	 */
	public void testToString()
	{
		assertEquals("VA"
				+ "\n"
				+ "Asian: 5000 cases, 0.2% CFR"
				+ "\n"
				+ "Black: 4000 cases, 0.3% CFR"
				+ "\n"
				+ "White: 3000 cases, 0.4% CFR"
				+ "\n"
				+ "====="
				+ "\n"
				+ "White: 3000 cases, 0.4% CFR"
				+ "\n"
				+ "Black: 4000 cases, 0.3% CFR"
				+ "\n"
				+ "Asian: 5000 cases, 0.2% CFR"
				+ "\n"
				+ "=====", state.toString());
	}

}
