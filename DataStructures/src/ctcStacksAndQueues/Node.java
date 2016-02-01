package ctcStacksAndQueues;


public class Node {
	
    int newmin;
	int value;
	Node next;
	
	public Node(int value,int newmin){
		this.newmin=newmin;
		this.value=value;
		next=null;
	}
	
	public void display(){
		
		System.out.println(" Value is " + value+" and the minimum is "+newmin);
		
	}
	
}
