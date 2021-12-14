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
            case 0: {
            	/*
            	 * replace the character at the index of 0, where the position of the blank tile has been found, with a temporary
            	 * character (#), and then replace this with the character in adjacent space to blank tile
            	 */
                children.add(parent.replace(parent.charAt(0), '#').replace(parent.charAt(1), parent.charAt(0)).replace('#', parent.charAt(1)));
                children.add(parent.replace(parent.charAt(0), '#').replace(parent.charAt(3), parent.charAt(0)).replace('#', parent.charAt(3)));
                break;
            }
            case 1: {
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(0), parent.charAt(1)).replace('#', parent.charAt(0)));
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(2), parent.charAt(1)).replace('#', parent.charAt(2)));
                children.add(parent.replace(parent.charAt(1), '#').replace(parent.charAt(4), parent.charAt(1)).replace('#', parent.charAt(4)));
                break;
            }
            case 2: {
                children.add(parent.replace(parent.charAt(2), '#').replace(parent.charAt(1), parent.charAt(2)).replace('#', parent.charAt(1)));
                children.add(parent.replace(parent.charAt(2), '#').replace(parent.charAt(5), parent.charAt(2)).replace('#', parent.charAt(5)));
                break;
            }
            case 3: {
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(0), parent.charAt(3)).replace('#', parent.charAt(0)));
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(4), parent.charAt(3)).replace('#', parent.charAt(4)));
                children.add(parent.replace(parent.charAt(3), '#').replace(parent.charAt(6), parent.charAt(3)).replace('#', parent.charAt(6)));
                break;
            }
            case 4: {
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(1), parent.charAt(4)).replace('#', parent.charAt(1)));
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(3), parent.charAt(4)).replace('#', parent.charAt(3)));
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(5), parent.charAt(4)).replace('#', parent.charAt(5)));
                children.add(parent.replace(parent.charAt(4), '#').replace(parent.charAt(7), parent.charAt(4)).replace('#', parent.charAt(7)));
                break;
            }
            case 5: {
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(2), parent.charAt(5)).replace('#', parent.charAt(2)));
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(4), parent.charAt(5)).replace('#', parent.charAt(4)));
                children.add(parent.replace(parent.charAt(5), '#').replace(parent.charAt(8), parent.charAt(5)).replace('#', parent.charAt(8)));
                break;
            }
            case 6: {
                children.add(parent.replace(parent.charAt(6), '#').replace(parent.charAt(3), parent.charAt(6)).replace('#', parent.charAt(3)));
                children.add(parent.replace(parent.charAt(6), '#').replace(parent.charAt(7), parent.charAt(6)).replace('#', parent.charAt(7)));
                break;

            }
            case 7: {
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(4), parent.charAt(7)).replace('#', parent.charAt(4)));
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(6), parent.charAt(7)).replace('#', parent.charAt(6)));
                children.add(parent.replace(parent.charAt(7), '#').replace(parent.charAt(8), parent.charAt(7)).replace('#', parent.charAt(8)));
                break;
            }
            case 8: {
                children.add(parent.replace(parent.charAt(8), '#').replace(parent.charAt(5), parent.charAt(8)).replace('#', parent.charAt(5)));
                children.add(parent.replace(parent.charAt(8), '#').replace(parent.charAt(7), parent.charAt(8)).replace('#', parent.charAt(7)));
                break;
            }
        }
        return children;
    }
}