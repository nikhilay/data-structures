package ctcLinkedList;

public class CircularListStartPoint {
	
	public Node getStartPoint(Node firstnode){
		Node focusnode=firstnode;
		Node slow=focusnode;
		Node fast=focusnode;
		
		if(focusnode==null){
			System.out.println(" Empty list!!");
			return focusnode;
		}
		
		while(slow!=null)
		{  slow=slow.next;
		    fast=fast.next.next;
		    if(slow==fast){
			break;
		    }
		}
		
		if(slow==null && fast ==null){
			System.out.println(" Not a Circular List!!");
			return focusnode;
		 }
		
		slow=focusnode;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		   }
		System.out.println(" This is the starting point "+ slow.data);
		return slow;
		
		
	}

}
