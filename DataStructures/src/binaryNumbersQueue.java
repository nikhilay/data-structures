import java.util.Scanner;
import java.util.Stack;

public class binaryNumbersQueue {

	public static void main(String[] args) {
		System.out.print(" Enter the no ");
		Scanner sc= new Scanner(System.in);
		int val=sc.nextInt();
		sc.close();
		Stack<String> stk1=new Stack<String>();
		Stack<String> stk2=new Stack<String>();
		binaryNumbersQueue qu= new binaryNumbersQueue();
		
//		qu.add(1);
		qu.enqueue(stk1, "1");
		for(int i=1;i<=val;i++){
			String str=qu.dequeue(stk1, stk2);
			System.out.print(str+" ,");
			String str1=str+0;
			qu.enqueue(stk1, str1);
			String str2=str+1;
			qu.enqueue(stk1, str2);
			
		}		
			
			
			
			
		}
	
	public void enqueue(Stack<String> stk1, String dat){
		if(stk1.size()<=stk1.capacity())
		{stk1.push(dat);
		}else
		{System.out.println("Sorry!, Queue is full!! ");}
	}
		
	public String dequeue(Stack<String> stk1,Stack<String> stk2){
		String s="";
		if(stk1.empty()==true){
			System.out.println("Sorry!, Queue is Empty!! ");
			
		}else{
		while(stk1.empty()==false)
		{
			stk2.push(stk1.pop());
	}
		 s= stk2.pop();
		while(stk2.empty()==false){
			stk1.push(stk2.pop());
		}
		//return s;
		}
		return s;
	}
		
		

	}


