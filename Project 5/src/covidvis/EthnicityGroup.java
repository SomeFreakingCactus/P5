package covidvis;
import java.text.*;

/**
 *  EthnicityGroup class represents a EthnicityGroup
 *  object
 *
 *  @author  Noah Coyle noahcoyle11
 *  @version 11/14/2020
 */
public class EthnicityGroup {
    
    private String name;
    private int cases;
    private double cfr;

    /**
     * Creates a new EthnicityGroup
     * @param group The name of the group
     * @param cases The amount of covid cases
     * @param cfr The case fatality ratio
     */
    public EthnicityGroup(String group, int cases, double cfr) {
        this.name = group;
        this.cases = cases;
        this.cfr = cfr;
    }
    
    /**
     * Get the name of the group
     * @return the name of the group
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the number of covid cases
     * @return the number of covid cases
     */
    public int getTotalCases() {
        return this.cases;
    }
    
    /**
     * Get the case fatality ratio
     * @return the case fatality ratio
     */
    public double getCfr() {
        return this.cfr;
    }

    /**
     * Compares two groups names
     * 
     * @param group The group being compared
     * @return if the groups have the same name
     */
    public int compareName(EthnicityGroup group) {
        if (group != null) {
            if (this.getName().equalsIgnoreCase(group.getName())) {
                return 0;
            }
            int result = this.getName().compareTo(group.getName());
            if (result > 0)
            {
                return 1;
            }
        }
        return -1;
    }
    
    /**
     * Compares two groups case fatality ratios
     * @param largest The group being compares
     * @return if the groups have the same cfr
     */
    public int compareCFR(EthnicityGroup largest) {
        if (largest != null) {
            if (this.cfr > largest.cfr) {
                return 1;
            }
            if (this.getCfr() == largest.getCfr()) {
                return 0;
            }
        }
        return -1;
    }
    
    /**
     * String representation of the EthnicityGroup
     * @return the string representation of the EthnicityGroup
     */
    public String toString() {
    	DecimalFormat df = new DecimalFormat("#.#");
    	if (this.getCfr() > 0 && this.getCfr() < 100) {
        return this.getName() + ": " + this.getTotalCases() 
            + " cases, " + df.format(this.getCfr()) + "% CFR";
    	}
    	return this.getName() + ": " + this.getTotalCases() 
        + " cases, " + -1 + "% CFR";
    	
    }
}
