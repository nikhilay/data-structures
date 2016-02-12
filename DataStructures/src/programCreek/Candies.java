package programCreek;

public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,4,3,3,3,1,2};
		 FindMinumumCandies(input,7);
	}
	
	static public void FindMinumumCandies(int[] ratings, int TotalNoOfStud ){
		if(ratings.length==0){
			System.out.println(" Has empty rating list");
			return;
		}else if(TotalNoOfStud==ratings.length){
			    int[] candies=new int[ratings.length];
			    candies[0]=1;
			    //Left to Right traversal
			    for(int i=1;i<ratings.length;i++){
			    	if(ratings[i-1]<ratings[i]){
			    		candies[i]=1+candies[i-1];
			    	}else{
			    		candies[i]=1;
			    	}
			      }
			    //Right to Left traversal
			    for(int i=ratings.length-2;i>=0;i--){
			    	if(ratings[i]>ratings[i+1]){
			    		candies[i]=1+candies[i+1];
			    	}
			      }
			    int MinChoc=0;
			    for(int i=0;i<candies.length;i++){
			    	MinChoc=MinChoc+candies[i];
			    }
			    System.out.println("Total No of Chocolates "+ MinChoc);
		}else{
			System.out.println(" Ratings not equal to total no of students");
		}
		
	}

}
