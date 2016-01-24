package ctcLinkedList;

public class TwoPointFourLLCTC {
	
       public Node partion(Node focusnode, int x){
       NodeMethods list1=new NodeMethods();
       NodeMethods list2=new NodeMethods();
	   Node temp=focusnode;
	   
	   if(temp==null){
		   System.out.println(" Empty List ");
		   return temp;
	    }else if (temp.next==null){
	    	System.out.println(" Only one Node ");
		return temp;  
	    }
	   
	   while(temp!=null){
	   if(temp.data<=x){
		  list1.insertFirst(temp.data);
		  temp=temp.next;
	   }else{
		   list2.insertFirst(temp.data);
		   temp=temp.next;}
	   }
	   
	    if(list2.firstnode!=null && list1.firstnode==null){
	     return list2.firstnode;
	    }else if(list1.firstnode!=null && list2.firstnode==null){
	    return list1.firstnode;
	    }
	    else{ 
	    	 while(list1.firstnode.next!=null){
	    		 list1.firstnode=list1.firstnode.next;
	    	 }
	    	 list1.firstnode.next=list2.firstnode;
	    	 return list1.firstnode;
	           }
	    	
	    }
	   
	   
       
       
}
