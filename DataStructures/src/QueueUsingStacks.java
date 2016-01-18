
import java.util.Stack;


public class QueueUsingStacks {

	public static void main(String[] args) {
	
		Stack<Integer> stk1=new Stack<Integer>();
		Stack<Integer> stk2=new Stack<Integer>();

		QueueUsingStacks qu= new QueueUsingStacks();
		
		qu.enqueue(stk1, 2);
		
		qu.enqueue(stk1, 4);
		System.out.println(qu.dequeue(stk1, stk2));
		qu.enqueue(stk1, 3);
		System.out.println(qu.dequeue(stk1, stk2));
		System.out.println(qu.dequeue(stk1, stk2));
	}
	
	public void enqueue(Stack<Integer> stk1, int dat){
		if(stk1.size()<=stk1.capacity())
		{stk1.push(dat);
		}else
		{System.out.println("Sorry!, Queue is full!! ");}
	}
		
	public int dequeue(Stack<Integer> stk1,Stack<Integer> stk2){
		int s=0;
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
