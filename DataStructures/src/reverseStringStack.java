import java.util.Scanner;


public class reverseStringStack {
	
	private int stacksize;
	private char[] stackstr;
	private int topofthestack=-1;
	
	reverseStringStack(int size){
	
		stacksize=size;
		 this.stackstr= new char[stacksize];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		reverseStringStack input= new reverseStringStack(50);
		
		//Scanner sc= new Scanner(System.in);
		
		//System.out.println(" Enter the word ");
//		while(sc.hasNextLine()){
//			char c = sc.next().charAt(0);
//			input.push(c);
//			//System.out.println("h");
//			
//		}
		char[] d={'d','i','d','o','g'};
		for(int i=0;i<d.length;i++){
			input.push(d[i]);;
		}
	
		
		while(input.topofthestack>=0){
	input.pop();
          }
		
	}	
	
	private void push(char q){
		if(topofthestack<stackstr.length){
			topofthestack++;
			stackstr[topofthestack]=q;
			
		}else{System.out.println("Sorry, stack is full !!");}
	}
	
	private void pop(){
		if(topofthestack<stackstr.length){
			System.out.print(stackstr[topofthestack]);
			stackstr[topofthestack]=' ';
			topofthestack--;
		 }else{System.out.println("Sorry, stack is empty !!");}
	}

}
