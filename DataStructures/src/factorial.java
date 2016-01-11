import java.util.Scanner;


public class factorial {
	

	public static void main(String[] args) {
		
		Scanner inputno= new Scanner(System.in);
		
		System.out.println("Please enter the number : ");
		int input=inputno.nextInt();
	    System.out.println("Factorial is : "+ factorialf(input));
	    inputno.close();
		
	}
	
	public static int factorialf(int input){
		 
		if(input==1){
			return 1;
		}else{ int p=input*factorialf(input-1);
		       return p;
		}
		
	}

}
