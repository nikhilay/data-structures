import java.util.Scanner;


public class DynaArray {

	public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 int seqno=sc.nextInt();
	 while(!(seqno>=1 && seqno<=100000)){
		 seqno=sc.nextInt();
	 }
     int queryno=sc.nextInt();
     int[][] input= new int[queryno][3];
     
     for(int i=0; i<queryno;i++){
    	 for(int j=0;j<3;j++){
    		 int temp=sc.nextInt();
    		 if(temp>=0 && temp<=1000000000){
    		 input[i][j]=temp;
    		 }
    	 }
     }
	  int lastans=0;
	  int t=0;
	  int[][] k=new int[queryno+1][queryno+1];
	  for(int i=0;i<k.length;i++){
		  for(int j=0;j<k.length;j++)
		  {k[i][j]=-1; }
	  }
	  for(int i=0; i<queryno;i++){
	    	if(input[i][0]==1){
	    		int w=0;
	    		     for(int q=0;q<queryno+1;q++){
	    		    	 if(k[q][0]==(input[i][1]^lastans)%seqno){
	    		    		 w++;}
	    		     }
	    		    if(w==0){
	    			 k[t][0]=(input[i][1]^lastans)%seqno;
	    			 for(int y=1;y<k.length;y++)
	    			 {
	    				 if(k[t][y]==-1){
	    					 k[t][y]=input[i][2];
	    					 break;
	    				 }
	    			 }
	    			 t++;
	    		    }else{
	    		    	 for(int y=0;y<k.length;y++)
		    			 {if(k[y][0]==(input[i][1]^lastans)%seqno){
		    				 for(int s=1;s<k.length;s++){
		    				 if(k[y][s]==-1){
		    					 k[y][s]=input[i][2];
		    					 break;
		    				 }
		    				 }
		    			 }
		    			 }
	       }
	 
	 
	}else{
		for(int q=0;q<k.length;q++){
	    	 if(k[q][0]==(input[i][1]^lastans)%seqno){
	    		 int v=0;
	    		 for(int d=1;d<k.length;d++)
	    		   { if(k[q][d]>=0){v++; }       
	    		     }
	    		 System.out.println(k[q][(input[i][2]%v)+1]);
	    		 lastans=v;
	    		 break;
	    	    }
	    	 
	        }
	    	 }
	}
	    	
	  }
}
