import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class dfs_search {
	private Node root;

    public dfs_search(Node root) {
        this.root = root;
    }
	
    /**
     * Carries out a depth first search for the 8puzzle based off the user's inputed states. This function
     * first starts by making a set to hold the visitedStates, of which is later returned to the main function call
     * in dfs_main.
     * A node is then created as the root/start of the search.
     * Two LIFO queues of nodes are made; one holds the nodes which are to be expanded (expansionNodes) and another
     * which contains successors to the expanded nodes (successorQueue).
     * The root node is assigned as the current node, and it is taken into a while loop which compares the set of all
     * visited nodes and the current node to find a match. While there is no match between the two, the loop will run.
     * 
     * The current node being investigated is added to the set holding all visited states, and then the children of
     * this node are found through the getChildren method of the Node class; the children of the current node is stored
     * as a list of Strings - Strings are used to represent the state of the 8 puzzle.
     * A nested for loop is then entered which iterates through all children of the current node, if a child has
     * already been visited previously, the for loop is broken, otherwise the loop adds the child to the visited nodes
     * set, and then also adds the child to the successorQueue so that it can be further expanded when the while loop
     * iterates further.
     * 
     * After the nested for loop, the queue containing successors of visited node are added to the beginning of the
     * expansion queue via the addQueue method of the dfs_queue class; added to the front to reflect LIFO property of
     * depth first searches. After this, the successor queue is cleared/reset so that it can store the while loop's 
     * next iteration of successors to the newly expanded expansionNodes queue. 
     * 
     * The current node is then removed from the queue so that it is not iterated over in the next iteration of
     * the while loop. Additionally, the list of children is reset so that it can be used over the next iteration of
     * the main while loop.
     * 
     * At the very end of this function, the size of the set of reachable nodes is printed to the console, and the
     * set of visited nodes (reachable nodes from the start node/root) is returned
     * @return The set of all reachable states from the start node inputed by the user
     */
	public Set<String> depthFirstSearch() {
        Set<String> visitedStates = new HashSet<String>();
        Node node = new Node(root.getState());
        dfs_queue<Node> expansionNodes = new dfs_queue<>();		// the nodes which are to be expanded
        dfs_queue<Node> successorQueue = new dfs_queue<>();		// successors/children to the expanded nodes
        Node currNode = node;
        while (!visitedStates.contains(currNode)) {		// while current Node is not found in visitedStates
            visitedStates.add(currNode.getState());
            List<String> children = Node.getChildren(currNode.getState());
            for (String state : children) {
                if (visitedStates.contains(state))		// next iteration if the child has previously been visited
                    continue;
                visitedStates.add(state);
                Node child = new Node(state);
                successorQueue.enqueue(child);
            }
            expansionNodes.addQueue(successorQueue);	// add successorQueue to the FRONT of expansionNodes
            successorQueue.clear();			// reset the queue of successors/children to the expanded nodes
            try {
            	currNode = expansionNodes.dequeue();
            } catch (Exception e) {
            	break;
            }
            children.clear();				// reset the list of children of the current node
            // System.out.println(currNode.getState());
            
        }
        System.out.println("SIZE: " + Integer.toString(visitedStates.size()));
        return visitedStates;
    }

}