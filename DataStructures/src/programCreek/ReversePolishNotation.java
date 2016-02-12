package programCreek;
import java.util.*;

public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input={"2", "1", "+", "3", "*"};
		evaluate(input);
	}

	static public void evaluate(String[] input){
		if(input.length==0){
			System.out.println(" Empty Array");
		}else{Stack<Integer> stk= new Stack<Integer>();
			   for(int i=0;i<input.length;i++){
//				   int a=Integer.parseInt(input[i]);
//				   int b=Integer.parseInt(input[i+1]);
				   if(input[i]!="+"&&input[i]!="-"&&input[i]!="*"&&input[i]!="/"){
				       stk.push(Integer.parseInt(input[i]));
				   }else{int a=stk.pop();
		             int b=stk.pop();
					   switch (input[i]){
					   case "+": 
					             stk.push(a+b);
					             break;
					   case "-": 
			                   stk.push(a-b);
			                   break;
					   case "/": 
		                   stk.push(a/b);
		                   break;
					   case "*": 
		                   stk.push(a*b);
		                   break;
					   }
				   
				  
				   }
			   }
			   System.out.println(stk.pop());
		}
		
	}
	
}
