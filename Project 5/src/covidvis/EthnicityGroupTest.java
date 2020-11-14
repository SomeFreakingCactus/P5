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
     * same name as another
     */
    public void testCompareNameFalse() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals(1, this.group.compareName(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same cfr as another
     */
    public void testCompareCfrNull() {
        EthnicityGroup group1 = null;
        assertEquals(-1, this.group.compareCFR(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same cfr as another
     */
    public void testCompareCfrTrue() {
        EthnicityGroup group1 = new EthnicityGroup("asian", 3290, 2.5);
        assertEquals(0, this.group.compareCFR(group1));
    }
    
    /**
     * tests if the EthnicityGroup has the
     * same cfr as another
     */
    public void testCompareCfrFalse() {
        EthnicityGroup group1 = new EthnicityGroup("black", 12922, 3.7);
        assertEquals(1, this.group.compareCFR(group1));
    }
}
