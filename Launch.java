
public class Launch {
    final static private String EASY = "134862705";
    final static private String MEDIUM = "123456780";
    final static private String HARD = "567408321";
    final static private String GOAL_STATE = "123804765";



    public static void main(String[] args) {
        String rootState = EASY;
        
        

        SearchTree search = new SearchTree(new Node(rootState));
        search.depthFirstSearch();
    }
    
    
    
    
    
    
    
    
    
    private static int[][] strToArr(String input) {
    	int[][] state = new int[3][3];
    	
    	
    	return state;
    }
    
    private static void prompt() {
    	System.out.println("====== Depth First Search ======");
    	System.out.println(" Enter the states as a 2D array ");
    	System.out.println("	i.e., for the state");
    	System.out.println("		[[1, 2, 3],		");
    	System.out.println("		 [4, 0, 5],		");
    	System.out.println("		 [6, 7, 8]]		");
    	System.out.println("Input: [[1,2,3],[4,0,5],[6,7,8]]");
    }
}
