import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class dfs_main {
	public static void main(String[] args) {
		prompt();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		
	    System.out.println("Enter first state (S1): ");
	    String S1 = myObj.nextLine();	          
	    System.out.println("Enter second state (S2): ");
	    String S2 = myObj.nextLine();
	    
	    System.out.println("S1:");    
	    dfs_search searchS1 = new dfs_search(new Node(format(S1)));
	    Set<String> RS1 = new HashSet<>(searchS1.depthFirstSearch());	// set of S1's states as hashset
	    List<String> listS1 = new ArrayList<String>();					// set -> list
	    listS1.addAll(RS1);
	    
	    System.out.println("S2:");    
	    dfs_search searchS2 = new dfs_search(new Node(format(S2)));
	    Set<String> RS2 = new HashSet<>(searchS2.depthFirstSearch());	// set if S2's states as hashset
	    List<String> listS2 = new ArrayList<String>();					// set -> list
	    listS2.addAll(RS2);
	    
	    System.out.println("Getting similarities:");					// compare the lists
	    List<String> differences = new ArrayList<>(listS1);
	    differences.removeAll(listS2);
	    listS1.removeAll(differences);
	    System.out.println(listS1.size());
    }
	
    private static void prompt() {
    	System.out.println("====== Depth First Search ======");
    	System.out.println(" Enter the states as a 2D array ");
    	System.out.println("	i.e., for the state");
    	System.out.println("		[[1, 2, 3],		");
    	System.out.println("		 [4, 0, 5],		");
    	System.out.println("		 [6, 7, 8]]		");
    	System.out.println("Input: [[1,2,3],[4,0,5],[6,7,8]]");
    	System.out.println("       [[8,4,2],[1,6,3],[0,5,7]]");
    }
    
    private static String format(String input) {
    	return input.replaceAll("[^0-9.]", "");
    }
}
