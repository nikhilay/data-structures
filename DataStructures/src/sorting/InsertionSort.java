package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] test={1787,656,90,464,2,21,33,767687878,8989,2121212121};
		insertionSort(test);
	}
	
	public static void insertionSort(int[] input)
	{
	  for (int i=1; i<input.length;i++)
	  { int temp=input[i];
	    int j=i-1;
      while( j>=0&&input[j]>temp)
	    {
	         input[j+1]=input[j];
	         input[j]=temp;
	         j--;
	         
	    }
	    
	  }
	  
	  for (int q=0;q<input.length;q++)
	  {System.out.print(input[q]+" ");
    }
	}
	
	}

