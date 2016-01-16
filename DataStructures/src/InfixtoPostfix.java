import java.util.Scanner;
import java.util.Stack;


public class InfixtoPostfix {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the expression");
		String inp=sc.nextLine();
		
		
		Stack<Character> stk = new Stack<>();
		sc.close();
		char[] c=inp.toCharArray();
		
		for(int i=0;i<c.length;i++){
			if(c[i]>='a'&&c[i]<='z' ||c[i]>='A'&&c[i]<='Z'){
			  System.out.print(c[i]);
			 }else{
				 if(stk.isEmpty()){
					 stk.push(c[i]);
				 }else{ switch(c[i]){
				        case '+': case '-':
				                if(stk.peek().equals('+')||stk.peek().equals('-')||stk.peek().equals('('))
				                {stk.push(c[i]);
				                }else
				                {
				                  while((stk.isEmpty()==false)&&(stk.peek().equals('*')||stk.peek().equals('/'))){
				                	  System.out.print(stk.pop());  
				                  }
				                  stk.push(c[i]);
				                }
				                break;

				        case '*': case '/':
				        if(stk.peek().equals('+')||stk.peek().equals('-')||stk.peek().equals('*')||stk.peek().equals('/')||stk.peek().equals('('))
		                {stk.push(c[i]);
		                }
				        break;

				        case '(': 
				        stk.push(c[i]);
				        break;
				        
				        case ')':
				        while(!stk.peek().equals('(')){
				        	System.out.print(stk.pop());
				        }
				        
				        System.out.print(stk.pop());
				        System.out.print(')');
				        
				        
				        
				 }
					 
					 
					 
					 
				 }
			 }
			
		}
while(stk.isEmpty()==false){System.out.print(stk.pop());}
	}

}
