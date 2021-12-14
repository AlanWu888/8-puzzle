import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.io.FileWriter;

public class dfs_main {
	public static void main(String[] args) {
		prompt();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object to get user's inputs
		
	    System.out.println("Enter first state (S1): ");	
	    String S1 = myObj.nextLine();	          			// input for S1
	    System.out.println("Enter second state (S2): ");
	    String S2 = myObj.nextLine();						// input for S2
	    
	    
	    
	    System.out.println("S1:");    
	    dfs_search searchS1 = new dfs_search(new Node(format(S1)));		
	    Set<String> RS1 = new HashSet<>(searchS1.depthFirstSearch());	// set of all reachable states from S1
	    
	    System.out.println("S2:");    
	    dfs_search searchS2 = new dfs_search(new Node(format(S2)));
	    Set<String> RS2 = new HashSet<>(searchS2.depthFirstSearch());	// set of all reachable states from S1

	    writeToTextFile(S1, S2, RS1, RS2); 
	    
	    System.out.println("Getting similarities:");					// compare the sets
	    System.out.println(findIntersection(RS1, RS2).size());   
    }
	
	/**
	 * Writes the outcomes of the two states into a text file named "RESULTS.txt"
	 * @param input1	user's input for State 1 (S1)
	 * @param input2	user's input for State 2 (S2)
	 * @param rS1	set of all possible states reachable by S1
	 * @param rS2	set of all possible states reachable by S2
	 */
	private static void writeToTextFile(String input1, String input2, Set<String> rS1, Set<String> rS2) {
		 try {
		      FileWriter myWriter = new FileWriter("RESULTS.txt");
		      
		      /* 	Results for the first state, answers to:
		       *  		a. R(S1)
		       *  		b. |R(S1)|
		       */		
		      myWriter.write("TAG First state:  " + input1 + "     states: "+ rS1.size() + '\n');
		      Iterator<String> it_1 = rS1.iterator();
		      while(it_1.hasNext()){
		    	  myWriter.write(it_1.next() + " ");
		      }

		      myWriter.write(" " + '\n'+ '\n'+ '\n'+ '\n');
		      
		      /*	Results for the second state, answers to:
		       * 		c. R(S2)
		       *  		d. |R(S2)|
		       */		
		      myWriter.write("TAG Second state: " + input2 + "     states: "+ rS2.size() + '\n');
		      Iterator<String> it_2 = rS2.iterator();
		      while(it_2.hasNext()){
		    	  myWriter.write(it_2.next() + " ");
		      }
		      
		      myWriter.write(" " + '\n'+ '\n'+ '\n'+ '\n');
		      
		      /*	Results for intersection of RS1 and RS2, answers to:
		       * 		e. R(S1) INTERSECT R(S2) 
		       * 		f. |R(S1) INTERSECT R(S2)|
		       */
		      Set<String> similaritiesSet = findIntersection(rS1, rS2);
		      myWriter.write("TAG Matches found: " + similaritiesSet.size() + '\n');
		      Iterator<String> it_intersection = rS2.iterator();
		      while(it_intersection.hasNext()){
		    	  myWriter.write(it_intersection.next() + " ");
		      }
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * Returns the intersection between the two sets RS1 and RS2
	 * @param rS1	set of all possible states reachable from S1
	 * @param rS2	set of all possible states reachable from S2
	 * @return	the intersection of RS1 and RS2
	 */
	private static Set<String> findIntersection(Set<String> rS1, Set<String> rS2) {
		rS1.retainAll(rS2);
		return rS1;
	}
	
	/**
	 * Message prompt for user to read, contains instructions on how to input a state
	 */
    private static void prompt() {
    	System.out.println("====== Depth First Search ======");
    	System.out.println(" Enter the states as a 2D array ");
    	System.out.println("	i.e., for the state");
    	System.out.println("		[[1, 2, 3],		");
    	System.out.println("		 [4, 0, 5],		");
    	System.out.println("		 [6, 7, 8]]		");
    	System.out.println("Input: [[1,2,3],[4,0,5],[6,7,8]]");
    	// System.out.println("       [[8,4,2],[1,6,3],[0,5,7]]");
    }
    
    /**
     * Formats user input so it can be processed by program. This function removes all non-numeric
     * characters from the input Strings given by the user.
     * @param input	String which user uses to represent their 2D array of puzzle state
     * @return	String of digits
     */
    private static String format(String input) {
    	return input.replaceAll("[^a-zA-Z0-9]", "");
    	// return input.replaceAll("[^0-9.]", "");
    }
}
