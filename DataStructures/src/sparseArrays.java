import java.util.Scanner;


public class sparseArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int strlines=sc.nextInt();
        while(!(strlines>=1 && strlines<=1000)){
        	strlines=sc.nextInt();
        }
	    sc.nextLine();
	    String temp1;
	    String[] input=new String[strlines];
	    for(int i=0;i<strlines;i++){
	    	temp1=sc.nextLine();
	    	while(temp1.length()<=20 && temp1.length()>=1){
	    	input[i]=temp1;
	    	break;
	    	}
	    }
	//String temp2;
	   int queryno=sc.nextInt();
	   while(!(queryno>=1 && queryno<=1000)){
		   queryno=sc.nextInt();
       }
	   sc.nextLine();
	   int[] readthis= new int[queryno];
	   int temp=0;
	   String[] queries= new String[queryno];
	   for(int i=0;i<queryno;i++){
		   temp1=sc.nextLine();
		   while(temp1.length()<=20 && temp1.length()>=1){
		  queries[i]=temp1;
		  break;
		   }
	   }
	   
	   for(int i=0;i<queries.length;i++)
	   {
		   for(int j=0;j<input.length;j++)
		   {
			   if(queries[i].equals(input[j])){
				   temp=temp+1;
			   }
		   }
		   readthis[i]=temp;
		   temp=0;
	   }
	   for(int i=0;i<readthis.length;i++){
		   System.out.println(readthis[i]);
	   }
	
	}
	

}
