package ctcLinkedList;

public class Node {

	int data;
	Node next;
	
	public Node(int d){
		data=d;
		next=null;
	}
	
	public void display(){
		System.out.println(" Data is :" + data);
	}
	
}
