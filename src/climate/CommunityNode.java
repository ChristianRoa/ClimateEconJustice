package climate;

/**
 * This class contains the Community Node, with a String containing the
 * community's name, a next pointer containing the next Community in the list,
 * and
 * a Data containing the information about this community.
 *
 * This Node makes the third layer in the 3-layered linked structure.
 * 
 * @author Navya Sharma
 */

public class CommunityNode {
    public String name; // community name
    public CommunityNode next; // link to the next community in the layer (community linked list)
    public Data info; // information about this community

    /*
     * Default constuctor: creates a node with null name, info, and references.
     */
    public CommunityNode() {
        this.name = null;
        this.next = null;
        this.info = null;
    }

    /**
     * Three argument constuctor: creates a node with name, next, and info from
     * parameter
     * 
     * @param name the name of this community
     * @param next the next reference of this node
     * @param info the Data object to store from this object
     */
    public CommunityNode(String name, CommunityNode next, Data info) {
        this.name = name;
        this.next = next;
        this.info = info;
    }

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
    public void setNext(CommunityNode next) {
        this.next = next;
    }

    /**
     * Obtains the next node
     * 
     * @return a CommunityNode reference to the next node
     */
    public CommunityNode getNext() {
        return next;
    }

    /**
     * Sets the Data object holding info of this node
     * 
     * @param info the new Data object holding community info
     */
    public void setInfo(Data info) {
        this.info = info;
    }

    /**
     * Gets the Data object holding info of this node
     * 
     * @return the Data object holding community info
     */
    public Data getInfo() {
        return info;
    }

    /*
     * Returns true if CommunityNode contain the same name
     * 
     * @param other object to compare
     * @return true if other contains the name name
     */
    public boolean equals (Object other) {

        if ( other instanceof CommunityNode ) {
            CommunityNode o = (CommunityNode) other;
            return this.getName().equals(o.getName());
        } else {
            return false;
        }
    }
}