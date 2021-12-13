import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class dfs_search {
	private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public dfs_search(Node root) {
        this.root = root;
    }
	
	public Set<String> depthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        Node node = new Node(root.getState());
        dfs_queue<Node> mainQueue = new dfs_queue<>();
        dfs_queue<Node> successorsQueue = new dfs_queue<>();
        Node currentNode = node;
        while (!stateSets.contains(currentNode)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = Node.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                successorsQueue.enqueue(child);

            }
            //we add the queue that contains the successors of the visted node to the beginning of the main queue
            mainQueue.addQueue(successorsQueue);
            //successors queue should be cleared in order to store the next expaneded's successors
            successorsQueue.clear();
            try {
            	currentNode = mainQueue.dequeue();
            } catch (Exception e) {
            	break;
            }
            nodeSuccessors.clear();
            // System.out.println(currentNode.getState());
            
        }
        System.out.println("SIZE: " + Integer.toString(stateSets.size()));
        return stateSets;
    }

}