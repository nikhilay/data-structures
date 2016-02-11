package ctcRecursionAndDP;

public class ChildHopDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] check= new int[6];
		System.out.println(" Total number of ways child can hop to reach end "+ paths(3,check));
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
