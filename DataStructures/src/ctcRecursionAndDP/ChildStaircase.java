package ctcRecursionAndDP;

import java.sql.Timestamp;
import java.util.Date;
//import java.sql.Timestamp;

public class ChildStaircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
       System.out.println(" Total number of ways child can hop to reach end "+ paths(30));
       long end = System.nanoTime();
       long microseconds = (end - start);
       System.out.println(microseconds);
	}
//	static public int totalPaths(int sum){
//		int add1=paths(sum,1);
//		int add2=paths(sum,2);
//		int add3=paths(sum,3);
//		return add1+add2+add3;	
//	}
	
	static public int paths(int sum){
		if(sum==0){
			return 1;
		 }else if(sum<0){
			return 0;
		 }else{
		    return paths(sum-3)+paths(sum-2)+paths(sum-1);
		 }
	}

}
