package ctcLinkedList;

public class LlTwoPointThreeCTC {

	public void delete(	Node focusnode){
		Node curr=focusnode;
		if(curr==null ||curr.next==null){
			return;
		}
		
		if(curr!=null){
			curr.data=curr.next.data;
			curr.next=curr.next.next;
			
		}
		
	}
	
}
