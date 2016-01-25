package ctcStacksAndQueues;
import java.util.*;
public class AscendingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> inp= new Stack<Integer>();
		Stack<Integer> out= new Stack<Integer>();
		inp.add(2);
		inp.add(4);
		inp.add(5);
		inp.add(5);
		inp.add(3);
		inp.add(33);
		inp.add(1);
		inp.add(43);
		
		out=Ascending(inp);
		
		while(!out.isEmpty()){
			System.out.print(out.pop()+" ");
		}
	}
	
	static public Stack<Integer> Ascending(Stack<Integer> inp){
		Stack<Integer> tempstk= new Stack<Integer>();
		int temp;
		temp= inp.pop();
		while(!inp.isEmpty()){
		if(inp.peek()<temp){
			if(tempstk.isEmpty()){
				tempstk.push(inp.pop());}
			else{if(tempstk.peek()>inp.peek()){
				tempstk.push(temp);
				temp=inp.pop();
				while(tempstk.peek()>temp){
					inp.push(tempstk.pop());
				}
				tempstk.push(temp);
				temp=inp.pop();
//				while(!inp.isEmpty()){
//					tempstk.push(inp.pop());
//				}
//				return tempstk;
			}else{
			tempstk.push(inp.pop());}}
			
		}else if(inp.peek()>=temp){
			 tempstk.push(temp);
			 temp=inp.pop();
		    }
	     }
		tempstk.push(temp);
		return tempstk;
	  }

}
