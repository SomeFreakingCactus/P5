package covidvis;

import student.TestCase;
/**
 *  EthnicityGroupTest will test all of the methods in EthnicityGroup
 *  to make sure that they run and perform as expected
 *
 * @author  Noah Coyle noahcoyle11
 * @version 11/14/2020
 */
public class EthnicityGroupTest extends TestCase {
    
    private EthnicityGroup group;
    
    /**
     * Sets up each test method.
     */
    public void setUp() {
        this.group = new EthnicityGroup("asian", 3290, 2.5);
    }
    
    /**
     * tests creating a new EthnicityGroup
     */
    public void testNewEthnicityGroup() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals("black", group1.getName());
    }
    
    /**
     * tests getting the EthnicityGroup name
     */
    public void testGetName() {
        assertEquals("asian", this.group.getName());
    }
    
    /**
     * tests getting the amout of a EthnicityGroups
     * covid cases
     */
    public void testGetTotalCases() {
        assertEquals(3290, this.group.getTotalCases());
    }
    
    /**
     * tests getting the EthnicityGroup cfr
     */
    public void testGetCfr() {
        assertEquals(2.5, this.group.getCfr(), 0.1);
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same name as another
     */
    public void testCompareNameNull() {
        EthnicityGroup group1 = null;
        assertEquals(-1, this.group.compareName(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same name as another
     */
    public void testCompareNameTrue() {
        EthnicityGroup group1 = new EthnicityGroup("asian", 3290, 2.5);
        assertEquals(0, this.group.compareName(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * a name that is alphabetically before the other
     */
    public void testCompareNameLess() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals(-1, this.group.compareName(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * a name that is alphabetically after the other
     */
    public void testCompareNameGreater() {
        EthnicityGroup group1 = new EthnicityGroup("white", 12922, 3.7);
        assertTrue(group1.compareName(this.group) > 0);
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same cfr as another
     */
    public void testCompareCfrNull() {
        EthnicityGroup group1 = null;
        assertTrue(this.group.compareCFR(group1) < 0);
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same cfr as another
     */
    public void testCompareCfrEquals() {
        EthnicityGroup group1 = new EthnicityGroup("asian", 3290, 2.5);
        assertEquals(0, this.group.compareCFR(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * smaller cfr as another
     */
    public void testCompareCfrLess() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals(-1, this.group.compareCFR(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * larger cfr as another
     */
    public void testCompareCfrGreater() {
        EthnicityGroup group1 = new EthnicityGroup("white", 15000, 1.7);
        assertEquals(1, this.group.compareCFR(group1));
    }
    
    /**
     * tests getting the EthnicityGroup toString
     */
    public void testToString() {
        assertEquals("asian: 3290 cases, 2.5% CFR", this.group.toString());
    }
    
    /**
     * tests toString method when CFR is negative (NA)
     */
    public void testToStringNA() {
        EthnicityGroup group1 = new EthnicityGroup("white", 15000, -1.7);
        assertEquals("white: 15000 cases, -1% CFR", group1.toString());
    }
    
    /**
     * tests getting the EthnicityGroup toString
     */
    public void testToString2() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals("black: 12922 cases, 3.7% CFR", group1.toString());
    }
    
    /**
     * tests getting the EthnicityGroup toString
     */
    public void testToStringZero() {
        EthnicityGroup group1 = new EthnicityGroup("asian", 3290, 0.0);
        assertEquals("asian: 3290 cases, -1% CFR", group1.toString());
    }
    
    /**
     * tests getting the EthnicityGroup toString
     */
    public void testToStringOver() {
        EthnicityGroup group1 = new EthnicityGroup("asian", 3290, 120.0);
        assertEquals("asian: 3290 cases, -1% CFR", group1.toString());
    }
}
