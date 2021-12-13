import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class SearchTree {
	private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public SearchTree(Node root) {
        this.root = root;
    }
	
	public void depthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        Node node = new Node(root.getState());
        MyQueue<Node> mainQueue = new MyQueue<>();
        MyQueue<Node> successorsQueue = new MyQueue<>();
        Node currentNode = node;
        while (!stateSets.contains(currentNode)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
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
            System.out.println(currentNode.getState());
            
        }
        System.out.println("SIZE: " + Integer.toString(stateSets.size()));

    }

}
