package climate;

/**
 * 
 * This class contains the County Node, with a String containing the County's
 * name,
 * a next pointer containing the next County in the list, and down pointer
 * containing
 * the first community in this county.
 * 
 * This Node makes the second layer in the 3-layered linked structure.
 * 
 * @author Navya Sharma
 */

public class CountyNode {
    public String name; // name of the county
    public CountyNode next; // link to the next County in the list
    public CommunityNode down; // link to the first Community in this county

    /**
     * Default constuctor: creates a node with null name and references
     */
    public CountyNode() {
        this.name = null;
        this.next = null;
        this.down = null;
    }

    /**
     * Three argument constructor: creates a node with name, next, and down
     * references.
     * 
     * @param name the name of this county
     * @param next the next reference of this node
     * @param down the down reference of this node
     */
    public CountyNode(String name, CountyNode next, CommunityNode down) {
        this.name = name;
        this.next = next;
        this.down = down;
    }

    // getter and setter methods

    /**
     * Sets the name of this node to parameter name
     * 
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of this node
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the next reference of this node to parameter
     * 
     * @param next the new next node
     */
    public void setNext(CountyNode next) {
        this.next = next;
    }

    /**
     * Obtains the next node
     * 
     * @return a CountyNode reference to the next node
     */
    public CountyNode getNext() {
        return next;
    }

    /**
     * Updates the down reference of this node
     * 
     * @param down the new down reference - MUST be a CommunityNode
     */
    public void setDown(CommunityNode down) {
        this.down = down;
    }

    /**
     * Returns the down reference (CommunityNode) of this node
     * 
     * @return the CommunityNode pointing down to this node
     */
    public CommunityNode getDown() {
        return down;
    }
    
    /*
     * Returns true if CountyNodes contain the same name
     * 
     * @param other object to compare
     * @return true if other contains the name name
     */
    public boolean equals (Object other) {

        if ( other instanceof CountyNode ) {
            CountyNode o = (CountyNode) other;
            return this.getName().equals(o.getName());
        } else {
            return false;
        }
    }
}