package ctcLinkedList;

public class ReverseOrderAddition {
	
	static public Node AdditionLL(Node list1, Node list2){
		Node focusnode1=list1;
		Node focusnode2=list2;
		NodeMethods result=new NodeMethods();
		int a,b,value = 0;//if I remove zero. somehting happended...ask why??
		int carry=0;
		if(list1==null && list2 ==null){
			System.out.println(" Both are emply list and cannot add");
			return list2;
		}else if(list1==null && list2!=null){
			System.out.println(" List 1 is empty, so cannot add");
			return list2;
		}else if(list2==null && list1!=null)
			{System.out.println(" List 2 is empty, so cannot add");
			return list1;}
		   
		while(focusnode1!=null || focusnode2!=null){
		   if(focusnode1!=null){
			    a=focusnode1.data;
			    
		   }else{a=0;}
		   
		   if(focusnode2!=null){
			   b=focusnode2.data;
			   
		   }else{b=0;}
		   
		   value=a+b+carry;
		   if(focusnode1!=null && focusnode2!=null)  
		    {result.insertFirst(value%10);
		     carry=value/10; 
		   
		    }
		   focusnode1=focusnode1.next;
		   focusnode2=focusnode2.next;
		    }
		if(value>10){
			result.insertFirst(value/10);	
		}
		return result.firstnode;
		}
		
	 
	     
		
		
		
	}

	
	
	
	
	
	
