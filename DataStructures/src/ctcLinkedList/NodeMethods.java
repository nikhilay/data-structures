package 
ctcLinkedList;

public class NodeMethods {
	public Node firstnode;
   public NodeMethods(){
	  firstnode=null;
   }
	
   public static void main(String[] args) {
   NodeMethods list1= new NodeMethods();
   NodeMethods list2= new NodeMethods();
   NodeMethods result= new NodeMethods();
   
      list1.insertFirst(1);
      list1.insertFirst(2);
      list1.insertFirst(3);
      list1.insertFirst(2);
      list1.insertFirst(1);
      System.out.println(Palindrome.check(list1.firstnode));
      list2.insertFirst(5);
     //list2.insertFirst(3);
      //list2.insertFirst(5);
      //result.firstnode=ReverseOrderAddition.AdditionLL(list1.firstnode, list2.firstnode);
       
      while(result.firstnode!=null){
    	  System.out.print(result.firstnode.data+" ");
    	  result.firstnode=result.firstnode.next;
      }
      
   }
	public void isEmpty(){
		if(firstnode==null){
			System.out.println(" List is Empty ");
		}else{System.out.println(" List is not Empty ");}
	}
	
	public void insertFirst( int d){
		Node newnode=new Node(d);
		if(firstnode!=null){
			newnode.next=firstnode;
			firstnode=newnode;
		}else{
			firstnode=newnode;
		}
	 }
	
	public Node removeFirst(){
		if(firstnode!=null){
		System.out.println(" First Element has been removed "+ firstnode.data);
		firstnode=firstnode.next;}
		return firstnode;
	}
	
	public void find( int d){
		if(firstnode!=null){
			while(firstnode!=null){
				if(firstnode.data==d){
					System.out.println(" Found!!! ");
					return;
				}
				firstnode=firstnode.next;
			    }
			System.out.println(" Not Found!!! ");
			
		}else{
		System.out.println(" Empty List!!! ");}
	}
	
	public Node removeLink(int d){
		if(firstnode!=null){
			Node prev=firstnode;
			Node curr=firstnode;
			if(firstnode.data==d){
				firstnode=firstnode.next;
				return firstnode;
			}
			while(curr!=null){
				if(curr.data==d){
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
