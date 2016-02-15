package programCreek;
import java.util.*;

public class BFS {
	HashMap<Integer, Boolean> IsNodeVisted= new HashMap<Integer, Boolean>();
	HashMap<Integer, Integer> parent= new HashMap<Integer, Integer>();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={
				       {0,1,2,3},
				       {1,4,5},
				       {2,6},
				       {3,7,8},
				       {4},
				       {5,9},
				       {9,10,11},
				       {6,11},
				       {7},
				       {8},
				       {10},
				       {11}
		               };
				       
			       
		}

   
	static public void bFS(int source,int[][] input){
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			//for child of each queue
			int child=0;
			int temp=queue.remove();
			for(int i=temp;i<input.length;i++)
			 if(!(IsNodeVisted.get(temp))){
				 IsNodeVisted.put(child, true);
				 parent.put(child,temp); 
				 queue.add(child);
			     
			    }
		  }
	 }
	
	static public void printPath(){
		
		
		}
}
