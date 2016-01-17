import java.util.Scanner;
import java.util.Stack;


public class BalancedParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc= new Scanner(System.in);
   System.out.println("Enter the expression");
    String inp=sc.nextLine();
    char[] c=inp.toCharArray();
    sc.close();;
    Stack<Character> stk= new Stack<Character>();
    checkbal(c,stk);
	}



static void checkbal(char[] c,Stack<Character> stk){
	
    for(int i=0;i<c.length;i++){
    	
        if(stk.isEmpty())
           {
      	  stk.push(c[i]);
      	 }else{
  	            switch (c[i]){
  	            
  	            case '{': case '[': case '(':
  	            	stk.push(c[i]);
  	            	break;
  	            case '}':
  	            	if(stk.peek()=='{')
  	            	{
  	            		stk.pop();
  	            		break;
  	            	}else if (stk.peek()=='('||stk.peek()=='[')
  	            	  {
  	            	   System.out.print(" not balanced !!");
  	            	   return;
  	            	  }
  	            case ')':
  	            	if(stk.peek()=='(')
  	            	{
  	            		stk.pop();
  	            		break;
  	            	}else if (stk.peek()=='{'||stk.peek()=='[')
  	            	  {
  	            	   System.out.print(" not balanced !!");
  	            	 return;
  	            	   }	
  	            case ']':
  	            	if(stk.peek()=='[')
  	            	{
  	            		stk.pop();
  	            		break;
  	            	}else if (stk.peek()=='('||stk.peek()=='{')
  	            	  {
  	            	   System.out.print(" not balanced !!");
  	            	 return;
  	            	   }
  	
  	
  	              }
                  }

     }
    System.out.print(" Balanced !!");
}


}