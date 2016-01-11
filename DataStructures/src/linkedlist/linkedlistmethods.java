package linkedlist;

public class linkedlistmethods {
	
	public linkedListNode firstlink;
	
	linkedlistmethods(){
		firstlink=null;
	}
	
	public void isEmpty(){
		if (firstlink==null){
			System.out.println("Empty List");
		}
	}
	
	public void insertFirst(String bookname, int millionSold){
		linkedListNode newlink= new linkedListNode(bookname,millionSold);
		newlink.next=firstlink;
		firstlink=newlink;
		
	}
	
	public linkedListNode removeFirst()
	{ linkedListNode linkreference= firstlink;
		if(firstlink!=null){ 
		firstlink=firstlink.next;
	     }
	else{System.out.println("Empty List");}
	return linkreference;
	}
	
	public void display(){
		linkedListNode linktraversal= firstlink;
		if(firstlink!=null){ 
			while(linktraversal!=null){
				linktraversal.display();
				System.out.println("Next link is :" + linktraversal.next+"\n");
				linktraversal=linktraversal.next;
				}
		     }
		else{System.out.println("Empty List");} 
	}
	
	public linkedListNode find(String book){
		linkedListNode linktraversal= firstlink;
		if(firstlink!=null){ 
			
			while(book!=linktraversal.bookname){ 
			 
			 if (linktraversal.next==null)
			 {System.out.println("We have reached last node and we could not find any matching node");
			 return null;}else{
			 linktraversal=linktraversal.next;}
			}
		     }
		else{System.out.println("Empty List");}
		return linktraversal;
		
	}
	
	public linkedListNode removelink(String book){
		linkedListNode currentlink=firstlink;
		linkedListNode previouslink=firstlink;
		if(firstlink!=null)
		  { while(book!=currentlink.bookname)
		     {
			  if (currentlink.next==null)
				 {System.out.println("We have reached last node and we could not find any matching node");
				 return null;}else{
					 previouslink=currentlink;
					 currentlink=currentlink.next;}
		     }
		   if (currentlink.bookname==firstlink.bookname)
		   { firstlink=firstlink.next;
		    }else
		    {   System.out.println("Found A Match");
		    	previouslink.next=currentlink.next;
		    }
		    }
		else
		  {System.out.println("Empty List");}
		return currentlink;
		
	}
	
	
	

}
