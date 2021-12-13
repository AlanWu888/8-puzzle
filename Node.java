import java.util.ArrayList;
import java.util.List;

public class Node {
    private boolean visited;
    
    private String state;
    private ArrayList<Node> children;
    private Node parent;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static List<String> getSuccessors(String state) {
        List<String> successors = new ArrayList<String>();

        switch (state.indexOf("0")) {
            case 0: {
                successors.add(state.replace(state.charAt(0), '#').replace(state.charAt(1), state.charAt(0)).replace('#', state.charAt(1)));
                successors.add(state.replace(state.charAt(0), '#').replace(state.charAt(3), state.charAt(0)).replace('#', state.charAt(3)));
                break;
            }
            case 1: {
                successors.add(state.replace(state.charAt(1), '#').replace(state.charAt(0), state.charAt(1)).replace('#', state.charAt(0)));
                successors.add(state.replace(state.charAt(1), '#').replace(state.charAt(2), state.charAt(1)).replace('#', state.charAt(2)));
                successors.add(state.replace(state.charAt(1), '#').replace(state.charAt(4), state.charAt(1)).replace('#', state.charAt(4)));
                break;
            }
            case 2: {
                successors.add(state.replace(state.charAt(2), '#').replace(state.charAt(1), state.charAt(2)).replace('#', state.charAt(1)));
                successors.add(state.replace(state.charAt(2), '#').replace(state.charAt(5), state.charAt(2)).replace('#', state.charAt(5)));
                break;
            }
            case 3: {
                successors.add(state.replace(state.charAt(3), '#').replace(state.charAt(0), state.charAt(3)).replace('#', state.charAt(0)));
                successors.add(state.replace(state.charAt(3), '#').replace(state.charAt(4), state.charAt(3)).replace('#', state.charAt(4)));
                successors.add(state.replace(state.charAt(3), '#').replace(state.charAt(6), state.charAt(3)).replace('#', state.charAt(6)));
                break;
            }
            case 4: {
                successors.add(state.replace(state.charAt(4), '#').replace(state.charAt(1), state.charAt(4)).replace('#', state.charAt(1)));
                successors.add(state.replace(state.charAt(4), '#').replace(state.charAt(3), state.charAt(4)).replace('#', state.charAt(3)));
                successors.add(state.replace(state.charAt(4), '#').replace(state.charAt(5), state.charAt(4)).replace('#', state.charAt(5)));
                successors.add(state.replace(state.charAt(4), '#').replace(state.charAt(7), state.charAt(4)).replace('#', state.charAt(7)));
                break;
            }
            case 5: {
                successors.add(state.replace(state.charAt(5), '#').replace(state.charAt(2), state.charAt(5)).replace('#', state.charAt(2)));
                successors.add(state.replace(state.charAt(5), '#').replace(state.charAt(4), state.charAt(5)).replace('#', state.charAt(4)));
                successors.add(state.replace(state.charAt(5), '#').replace(state.charAt(8), state.charAt(5)).replace('#', state.charAt(8)));
                break;
            }
            case 6: {
                successors.add(state.replace(state.charAt(6), '#').replace(state.charAt(3), state.charAt(6)).replace('#', state.charAt(3)));
                successors.add(state.replace(state.charAt(6), '#').replace(state.charAt(7), state.charAt(6)).replace('#', state.charAt(7)));
                break;

            }
            case 7: {
                successors.add(state.replace(state.charAt(7), '#').replace(state.charAt(4), state.charAt(7)).replace('#', state.charAt(4)));
                successors.add(state.replace(state.charAt(7), '#').replace(state.charAt(6), state.charAt(7)).replace('#', state.charAt(6)));
                successors.add(state.replace(state.charAt(7), '#').replace(state.charAt(8), state.charAt(7)).replace('#', state.charAt(8)));
                break;
            }
            case 8: {
                successors.add(state.replace(state.charAt(8), '#').replace(state.charAt(5), state.charAt(8)).replace('#', state.charAt(5)));
                successors.add(state.replace(state.charAt(8), '#').replace(state.charAt(7), state.charAt(8)).replace('#', state.charAt(7)));
                break;
            }
        }
        return successors;
    }
    
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


    // Constructor
    public Node(String state) {
        this.state = state;
        children = new ArrayList<Node>();
    }

    // Properties
    public String getState() {
        return state;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(Node child) {
        children.add(child);
    }
}