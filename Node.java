import java.util.ArrayList;

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