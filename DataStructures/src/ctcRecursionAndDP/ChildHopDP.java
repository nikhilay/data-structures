package ctcRecursionAndDP;
import java.sql.Timestamp;
import java.util.Date;

public class ChildHopDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] check= new int[21];
		long start = System.nanoTime();
		System.out.println(" Total number of ways child can hop to reach end "+ paths(20,check));
		 long end = System.nanoTime();
	       long microseconds = (end - start);
	       System.out.println(microseconds);
	}
	static public int paths(int sum,int[] check){
		if(sum==0){
			return 1;
		 }else if(sum<0){
			return 0;	
		 }else if(check[sum]>0){
			       return check[sum];
		 }else{ check[sum]= paths(sum-3,check)+paths(sum-2,check)+paths(sum-1,check);     
		    return check[sum];
		    
		 }
	}

}
