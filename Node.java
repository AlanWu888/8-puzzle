import java.util.ArrayList;
import java.util.List;

/**
 * Node object which is used to represent the state of the 8puzzle
 * contains methods:
 * 		> getState
 * 		> getChildren
 */
public class Node {
    private String state;

    // Constructor
    public Node(String state) {
        this.state = state;
    }
       
    // Getter methods
    public String getState() {
        return state;
    }
    
    /**
     * Returns a list of Strings/states that represent all children of a parent node. The children are calculated using
     * a switch case on the position of the blank tile. Based off the index of this tile, the function will replace
     * certain elements of the String representing a given state with one another. This function will then add this to
     * the list of children defined at the start of the function.
     * @param parent	parent node to the children it can lead to
     * @return list of Strings/states that represent all children of the parameterised parent
     */
    public static List<String> getChildren(String parent) {
        List<String> children = new ArrayList<String>();

        switch (parent.indexOf("0")) {
                /*
            	 * replace the character at the index of 0, where the position of the blank tile has been found, with a temporary
            	 * character (#), and then replace this with the character in adjacent space to blank tile
            	 */
            case 0: {   // Blank located at top left
                children.add(parent.replace(parent.charAt(0), '#').replace(parent.charAt(1), parent.charAt(0)).replace('#', parent.charAt(1))); // Move Right
                children.add(parent.replace(parent.charAt(0), '#').replace(parent.charAt(3), parent.charAt(0)).replace('#', parent.charAt(3))); // Move Down
                break;
            }
            case 1: {   // Blank located at top middle
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(0), parent.charAt(1)).replace('#', parent.charAt(0))); // Move Left
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(2), parent.charAt(1)).replace('#', parent.charAt(2))); // Move Right
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(4), parent.charAt(1)).replace('#', parent.charAt(4))); // Move Down
                break;
            }
            case 2: {   // Blank located at top right
                children.add(parent.replace(parent.charAt(2), '#').replace(parent.charAt(1), parent.charAt(2)).replace('#', parent.charAt(1))); // Move Left
                children.add(parent.replace(parent.charAt(2), '#').replace(parent.charAt(5), parent.charAt(2)).replace('#', parent.charAt(5))); // Move Down
                break;
            }
            case 3: {   // Blank located at middle left
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(0), parent.charAt(3)).replace('#', parent.charAt(0))); // Move Up
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(4), parent.charAt(3)).replace('#', parent.charAt(4))); // Move Right
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(6), parent.charAt(3)).replace('#', parent.charAt(6))); // Move Down
                break;
            }
            case 4: {   // Blank located at middle middle
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(1), parent.charAt(4)).replace('#', parent.charAt(1))); // Move Up
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(3), parent.charAt(4)).replace('#', parent.charAt(3))); // Move Left
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(5), parent.charAt(4)).replace('#', parent.charAt(5))); // Move Right
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(7), parent.charAt(4)).replace('#', parent.charAt(7))); // Move Down
                break;
            }
            case 5: {   // Blank located at middle right
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(2), parent.charAt(5)).replace('#', parent.charAt(2))); // Move Up
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(4), parent.charAt(5)).replace('#', parent.charAt(4))); // Move Left
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(8), parent.charAt(5)).replace('#', parent.charAt(8))); // Move Down
                break;
            }
            case 6: {   // Blank located at bottom left
                children.add(parent.replace(parent.charAt(6), '#').replace(parent.charAt(3), parent.charAt(6)).replace('#', parent.charAt(3))); // Move Up
                children.add(parent.replace(parent.charAt(6), '#').replace(parent.charAt(7), parent.charAt(6)).replace('#', parent.charAt(7))); // Move Right
                break;

            }
            case 7: {   // Blank located at bottom middle
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(4), parent.charAt(7)).replace('#', parent.charAt(4))); // Move Up
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(6), parent.charAt(7)).replace('#', parent.charAt(6))); // Move Left
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(8), parent.charAt(7)).replace('#', parent.charAt(8))); // Move Right
                break;
            }
            case 8: {   // Blank located at bottom right
                children.add(parent.replace(parent.charAt(8), '#').replace(parent.charAt(5), parent.charAt(8)).replace('#', parent.charAt(5))); // Move Up
                children.add(parent.replace(parent.charAt(8), '#').replace(parent.charAt(7), parent.charAt(8)).replace('#', parent.charAt(7))); // Move Left
                break;
            }
        }
        return children;
    }
}
