package ctcStacksAndQueues;


public class NodeMethods {
	public Node firstnode;
   public NodeMethods(){
	  firstnode=null;
   }
	
   public static void main(String[] args) {
//   NodeMethods list1= new NodeMethods();
//   NodeMethods list2= new NodeMethods();
//   NodeMethods result= new NodeMethods();
   
    
   
      
   }
	public boolean isEmpty(){
		if(firstnode==null){
			System.out.println(" List is Empty ");
			return true;
		}else{System.out.println(" List is not Empty ");
		return false;}
	}
	public int peek(){
		if(firstnode!=null){
			int val=firstnode.newmin;
			return val;
		}else{
			return 0;
		}
	}
	public void insertFirst(int value,int newmin){
		Node newnode=new Node(value,newmin);
		if(firstnode!=null){
			newnode.next=firstnode;
			firstnode=newnode;
		}else{
			firstnode=newnode;
		}
	 }
	
	public Node removeFirst(){
		if(firstnode!=null){
		System.out.println(" First Element has been removed "+ firstnode.value);
		firstnode=firstnode.next;}
		return firstnode;
	}
	
	public void find( int value){
		if(firstnode!=null){
			while(firstnode!=null){
				if(firstnode.value==value){
					System.out.println(" Found!!! ");
					return;
				}
				firstnode=firstnode.next;
			    }
			System.out.println(" Not Found!!! ");
			
		}else{
		System.out.println(" Empty List!!! ");}
	}
	
	public Node removeLink(int value){
		if(firstnode!=null){
			Node prev=firstnode;
			Node curr=firstnode;
			if(firstnode.value==value){
				firstnode=firstnode.next;
				return firstnode;
			}
			while(curr!=null){
				if(curr.value==value){
				prev.next=curr.next;
				return firstnode;
				}
				prev=curr;
				if(curr.next!=null){
				curr=curr.next;}else{System.out.println(" No element found in the list ");return firstnode;}
			}
			
			
		}else{
			System.out.println(" Empty List!!! ");return firstnode;}
		return firstnode;
	}
}

