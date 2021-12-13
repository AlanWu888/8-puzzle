import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.io.FileWriter;

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
	    Set<String> RS1 = new HashSet<>(searchS1.depthFirstSearch());	// set of S1's states as set
	    
	    System.out.println("S2:");    
	    dfs_search searchS2 = new dfs_search(new Node(format(S2)));
	    Set<String> RS2 = new HashSet<>(searchS2.depthFirstSearch());	// set if S2's states as set

	    writeToTextFile(S1, S2, RS1, RS2); 
	    
	    System.out.println("Getting similarities:");					// compare the sets
	    System.out.println(findIntersection(RS1, RS2).size());   
    }
	
	private static void writeToTextFile(String input1, String input2, Set<String> rS1, Set<String> rS2) {
		 try {
		      FileWriter myWriter = new FileWriter("RESULTS.txt");
		      myWriter.write("TAG First state:  " + input1 + "     states: "+ rS1.size() + '\n');
		      Iterator<String> it_1 = rS1.iterator();
		      while(it_1.hasNext()){
		    	  myWriter.write(it_1.next() + " ");
		      }

		      myWriter.write(" " + '\n'+ '\n'+ '\n'+ '\n');
		      
		      myWriter.write("TAG Second state: " + input2 + "     states: "+ rS2.size() + '\n');
		      Iterator<String> it_2 = rS2.iterator();
		      while(it_2.hasNext()){
		    	  myWriter.write(it_2.next() + " ");
		      }
		      
		      myWriter.write(" " + '\n'+ '\n'+ '\n'+ '\n');
		      
		      
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
	
	private static Set<String> findIntersection(Set<String> rS1, Set<String> rS2) {
		rS1.retainAll(rS2);
		return rS1;
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
