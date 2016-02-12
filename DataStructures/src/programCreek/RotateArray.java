package programCreek;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] input={1,2,3,4,5,6,7};
    rotation(3,input);
	}
   static public void rotation(int offset,int[] input){
	   int[] temp=new int[input.length];
	   for(int i=0;i<input.length;i++){
		   temp[(i+offset)%input.length]=input[i];
	   }
	   
	   for(int i=0;i<temp.length;i++){
		   System.out.print(temp[i]+" ");
	   }
   }
}
