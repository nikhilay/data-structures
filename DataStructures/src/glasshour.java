import java.util.Scanner;


public class glasshour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] inputarray= new int[6][6];
		int sum;
		String temp=" ";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the nos");
		for(int i=0;i<inputarray.length;i++){
			for(int j=0;j<inputarray.length;j++)
			{   
				inputarray[i][j]=sc.nextInt();
			
			}
		}
//		inputarray[0][0]=1;
//		inputarray[0][1]=1;
//		inputarray[0][2]=1;
//		inputarray[0][3]=0;
//		inputarray[0][4]=0;
//		inputarray[0][5]=0;
//		inputarray[1][0]=0;
//		inputarray[1][1]=1;
//		inputarray[1][2]=0;
//		inputarray[1][3]=0;
//		inputarray[1][4]=0;
//		inputarray[1][5]=0;
//		inputarray[2][0]=1;	
//		inputarray[2][1]=1;	
//		inputarray[2][2]=1;	
//		inputarray[2][3]=0;	
//		inputarray[2][4]=0;	
//		inputarray[2][5]=0;	
//		inputarray[3][0]=0;
//		inputarray[3][1]=0;
//		inputarray[3][2]=2;
//		inputarray[3][3]=4;
//		inputarray[3][4]=4;
//		inputarray[3][5]=0;
//		inputarray[4][0]=0;
//		inputarray[4][1]=0;
//		inputarray[4][2]=0;
//		inputarray[4][3]=2;
//		inputarray[4][4]=0;
//		inputarray[4][5]=0;
//		inputarray[5][0]=0;
//		inputarray[5][1]=0;
//		inputarray[5][2]=1;
//		inputarray[5][3]=2;
//		inputarray[5][4]=4;
//		inputarray[5][5]=0;
				
		for(int j=0;j+2<inputarray.length;j++){
			for(int i=0;i+2<inputarray.length;i++){
				sum=inputarray[i][j]+inputarray[i][j+1]+inputarray[i][j+2]+inputarray[i+1][j+1]
						+inputarray[i+2][j]+inputarray[i+2][j+1]+inputarray[i+2][j+2];
				
				temp=temp+sum+" ";
			}
			
			}
		
		String[] a= temp.trim().split("\\s");
		int[] max= new int[a.length];
		for(int t=0;t<a.length;t++){
			max[t]=Integer.parseInt(a[t]);
		}
		
		int temp1=max[0];
		for(int p=1;p<max.length;p++){
			if(max[p]>temp1){
			 temp1=max[p];
			}
			}
		System.out.print(temp1);
		}
		
	}

