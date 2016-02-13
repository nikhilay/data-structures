package programCreek;
import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={2,7,11,15,9,-3};
		printPairs(input,12);
	}
	
	static public void printPairs(int[] input, int target){
		if(input.length==0||input==null){
			System.out.println(" Empty array");
			return;
		}
		HashMap<Integer,Integer> hmap= new HashMap<Integer,Integer>(); 
		for(int i=0;i<input.length;i++){
			hmap.put(input[i],i);
		}
		int flag=0;
		for(int i=0;i<input.length;i++){
			if(hmap.containsKey(target-input[i])){
				if(i<hmap.get(target-input[i])){
				System.out.println("Index 1 = "+(i+1)+"|| Index 2 = "+(hmap.get(target-input[i])+1));
				flag=1;}
			}
		}
		
		if(flag==0){System.out.println(" Elements does not sum up to Target value");}
	}

}
