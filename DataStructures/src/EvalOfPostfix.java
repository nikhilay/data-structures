import java.util.Scanner;
import java.util.Stack;


public class EvalOfPostfix {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the expression");
		String inp =sc.nextLine().trim();
		
		sc.close();
		char[] c = inp.toCharArray();
		
		Stack<Integer> stk= new Stack<Integer>();
		
		for(int i=0;i<c.length;i++){
			if(c[i]>='0' && c[i]<='9')
			{
				stk.push(Integer.parseInt(String.valueOf(c[i])));
			}else{
				   int b=stk.pop();
				   int a=stk.pop();
				   int st;
				   switch (c[i]){
				   
				   case '+':
					   st=a+b;
					   stk.push(st);
					   break;
				   case '-':
					   st=a-b;
					   stk.push(st);
					   break;
					   
				   case '/':
					   st=a/b;
					   stk.push(st);
					   break;
					   
				   case '*':
					   st=a*b;
					   stk.push(st);
					   break;
				   
				   
				   }
			}
		}
		
		System.out.print(stk.pop());
		

	}

}
