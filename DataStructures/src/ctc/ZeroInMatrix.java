package ctc;
import java.util.*;

public class ZeroInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a=new int[4][5];
		Stack<Integer> setR= new Stack<Integer>();
		Stack<Integer> setC= new Stack<Integer>();
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j]==0){
					setR.add(i);
					setC.add(j);
				 }
			  }
		 }
		
		while(!setR.isEmpty()){
				int row = setR.pop();
				for(int k=0;k<a[0].length;k++)
				{  a[row][k]=0;
				     }
			}
		while(!setC.isEmpty()){
			int col = setR.pop();
			for(int k=0;k<a.length;k++)
			{  a[k][col]=0;
			     }
		}
		
		}

	}
	
	


