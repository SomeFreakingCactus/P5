package covidvis;

import student.TestCase;

/**
 * Test class for Calculator.
 * 
 * @author Kyle Hart (kylegh)
 * @version 2020.11.20
 */
public class CalculatorTest extends TestCase {

    /**
     * Tests all cases.
     */
    public void testAll() {
        State[] states = new State[3];
        SinglyLinkedList<EthnicityGroup> group =
            new SinglyLinkedList<EthnicityGroup>();
        EthnicityGroup white = new EthnicityGroup("white", 2, .4);
        EthnicityGroup black = new EthnicityGroup("black", 4, .2);
        group.add(white);
        group.add(black);
        states[0] = new State("A", group);
        states[1] = new State("B", group);
        states[2] = new State("C", group);

        Calculator calc = new Calculator(states);

        assertEquals(states, calc.states());

        assertEquals(states[2], calc.getStateByIndex(2));

        calc.sortAlpha();

        // assertEquals(0,
        // calc.getStateByIndex(0).getList().lastIndexOf(black));

        calc.sortCFR();

        assertEquals(1, calc.getStateByIndex(2).getList().lastIndexOf(black));
    }

}
