package climate;

/**
 * This class contains the State Node, with a String containing the State's
 * name,
 * a next pointer containing the next State in the list, and down pointer
 * containing
 * the first CountyNode in this county.
 * 
 * This Node makes the first layer in the 3-layered linked structure.
 * 
 * @author Navya Sharma
 */

public class StateNode {
    public String name; // state's name
    public StateNode next; // link to the next State in the list
    public CountyNode down; // link to the first County of this state

    /*
     * Default constuctor: creates a node with null name and references
     */
    public StateNode() {
        this.name = null;
        this.next = null;
        this.down = null;
    }

    /**
     * Three argument constructor: creates a node with name, next, and down
     * references.
     * 
     * @param name the name of this state
     * @param next the next reference of this node
     * @param down the down reference of this node
     */
    public StateNode(String name, StateNode next, CountyNode down) {
        this.name = name;
        this.next = next;
        this.down = down;
    }

    /**
     * Updates instance variable name.
     * 
     * @param name the new name to update with
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
    public void setNext(StateNode next) {
        this.next = next;
    }

    /**
     * Obtains the next node
     * 
     * @return a StateNode reference to the next node
     */
    public StateNode getNext() {
        return next;
    }

    /**
     * Updates the down reference of this node
     * 
     * @param down the new down reference - MUST be a CountyNode
     */
    public void setDown(CountyNode down) {
        this.down = down;
    }

    /**
     * Returns the down reference (CountyNode) of this node
     * 
     * @return the CountyNode pointing down to this node
     */
    public CountyNode getDown() {
        return down;
    }

    /*
     * Returns true if StateNodes contain the same name
     * 
     * @param other object to compare
     * @return true if other contains the name name
     */
    public boolean equals (Object other) {

        if ( other instanceof StateNode ) {
            StateNode o = (StateNode) other;
            return this.getName().equals(o.getName());
        } else {
            return false;
        }
    }
}