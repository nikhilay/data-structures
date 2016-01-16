
public class hackerankll {
	int data;
	hackerankll next;
	hackerankll prev;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
hackerankll head=new hackerankll();

head = head.Insert(head,2);
head.Insert(head,3);
head.Print(head);
	}
	
	
	hackerankll Delete(hackerankll head, int position) {
		  // Complete this method
		    int temp=0;
		    hackerankll current=head;
		    hackerankll previous=new hackerankll();
		    if(!(head==null)){
		      if(head.next==null&& position==0){
		          head=null;
		          return head;
		          
		      }else{
		            while(current!=null){
		            if(temp==position){
		                previous.next=current.next;
		                return head;
		            }
		            temp++;
		            previous=current;
		            current=current.next;
		        }
		      } 
		    }
		   return head; 
		}
	
	void ReversePrint(hackerankll head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method. 
		 if(head!=null){
		     printrecursion(head);
		 }
		}

		static void printrecursion(hackerankll y){
			hackerankll z=y;
		    if(y.next==null){
		        System.out.println(y.data);
		    }else{
		        z=y.next;
		          printrecursion(z);
		          System.out.println(y.data);
		    }
		}
		
		hackerankll Reverse(hackerankll head) {
			hackerankll z=head;
           llrrecursion(head);
		}
		
		static void llrrecursion(hackerankll y){
			if(y.next==null)
			{head=y;
			return head;}else{
				
			}
		}
	
	hackerankll Insert(hackerankll head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		hackerankll temp= new hackerankll();
		    if(head==null){
		        head.data=data;
		        head.next=null;
		        return head;
		        }else{
		        temp.data=data;
		        temp.next=head;
		        head=temp;
		        return head;
		    }
		    }
		    
	hackerankll InsertLast(hackerankll head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		hackerankll temp= new hackerankll();
		hackerankll traverse=head;
		    if(head==null){
		        head.data=data;
		        head.next=null;
		        return head;
		        }
		    else{while(!(traverse.next==null))
		    {
		    	traverse=traverse.next;
		    }
		        temp.data=data;
		        traverse.next=temp;
		        temp.next=null;
		        return head;
		    }
		    }
		    
	
	int CompareLists(hackerankll headA, hackerankll headB) {
	    // This is a "method-only" submission. 
	    // You only need to complete this method 
	    
	    if(headA==null && headB==null){
	        return 1;
	    }else if((headA==null&&headB!=null)||(headB==null&&headA!=null)){
	        return 0;
	    }else{ 
	        while(headA!=null &&headB!=null){
	        if(headA.data==headB.data){
	            headA=headA.next;
	             headB=headB.next;
	             if(headA!=null ||headB!=null){return 0;}
	        }else{return 0;}
	    }return 1;
	        
	    }
	  
	}
		
	
	int GetNode(hackerankll head,int n) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method.
	    int count=-1;
	    hackerankll temp=head;
		if(temp!=null) {
			while(temp!=null) {
		        count++;
		        temp=temp.next;
		    }
		    int c=-1;
		    int pos=count-n;
		    while(head!=null) {
		        c++;
		        if(c==pos) {
		            return head.data;
		        }
		        else {
		             head=head.next;
		             if(head==null){return head.data;} 
		        }    
		    }
		    return head.data;
		}
		else {
			return head.data;
		}
	}
//return temp.data;
	
	hackerankll RemoveDuplicates(hackerankll head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method.
		hackerankll temp= head;
		if(temp!=null){
		  while (temp!=null){
		      if(temp.data==temp.next.data) {
		          temp.next=temp.next.next;
		      }else{
		    	  temp=temp.next;
		      }
		  }
		  return head;
		} else
		  {return head;}
		}
	
	int HasCycle(hackerankll head) {
		hackerankll one=head;
		hackerankll two=head;
//		if(head!=null && head.next!=null && head.next.next!=null){
//			    one=one.next;
//		        two=two.next.next;}
//		        else{return 0;}
	    while(head!=null && head.next!=null && head.next.next!=null)
		    {one=one.next;
	         two=two.next.next;   
	    	if(one==two)
		           {return 1;}
		    
		      head=head.next;
		    }
		 return 0;

		}
	
	hackerankll InsertNth(hackerankll head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		    
		hackerankll current=head;
		hackerankll previous=head;
		hackerankll newnode=new hackerankll();
		    newnode.data=data;
		    int pos=-1;
		    
		    if (position==0 && head!=null){
		        newnode.next=current.next;
		        head=newnode;
		        return head;
		    }else{
		   while(current!=null){
		       pos++;
		       if(pos==position){ 
		              previous.next=newnode;
		              newnode.next=current;
		           return head;
		           
		       }else{previous=current;
		           current=current.next;
		           }
		   }
		    }
		     return head;  
		  
		    
		}
	
	
	hackerankll SortedInsert(hackerankll head,int data) {
		hackerankll current=head;
		
		hackerankll newnode=new hackerankll();
			    newnode.data=data;
			    
			    
			    if ( head==null){
			        newnode.next=null;
	                newnode.prev=null;
			        head=newnode;
			        return head;
			    }else{
			   while(current!=null){
			         if((current.next!=null && current.data<=data) && data<=current.next.data )
	                     {newnode.next=current.next;
	                     current.next=newnode;
	                     newnode.prev=current;
	                     newnode=current.next.next.prev;
	                     return head;}
			         else if(current.data<=data && current.next==null){
	                     newnode.next=null;
	                     newnode.prev=current;
	                     current.next=newnode;
	                 }
	               current=current.next;
			   }
			   return head;     
			    }
			      
			  
	}

	hackerankll Reverse1(hackerankll  head) {
		 if (head==null ||head.next==null)
		 {
		     return head;
		 }
		 hackerankll temp1;
		 hackerankll temp2;
		 hackerankll temp3=head;
		    temp1=temp3;
		    temp1.next=null;
		    
		    while(temp3!=null){
		    temp2=temp3.next;
		    temp2.next=temp1;
		      temp1=temp2;}
		    head=temp1;
		    return head;
		 
		    
		}
	
	hackerankll MergeLists(hackerankll headA, hackerankll headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method
		hackerankll tempA=headA;
		hackerankll tempB=headB;
		hackerankll connA;
		hackerankll connB;
	    if(headA==null){
	        return headB;
	    }else if(headB==null){
	        return headA;
	    }else{ if(tempA.data<=tempB.data){
	        while(tempA!=null && tempB!=null){
	        if(tempA.data<=tempB.data)
	          {  while(tempA.next.data<=tempB.data)
	            { tempA=tempA.next;}
	             connA=tempA.next;
	           tempA.next=tempB;
	           tempA=connA;
	           
	          }else if(tempA.next.data>tempB.data){
	            while(tempA.next.data>tempB.data)
	            { tempB=tempB.next;}
	             connB=tempB.next;
	           tempB.next=tempA;
	           tempB=connB;
	        }
	        }
	      return headA;  
	    }else{while(tempA!=null && tempB!=null){
	        if(tempA.data<=tempB.data)
	          {  while(tempA.next.data<=tempB.data)
	            { tempA=tempA.next;}
	             connA=tempA.next;
	           tempA.next=tempB;
	           tempA=connA;
	           
	          }else if(tempA.next.data>tempB.data){
	            while(tempA.next.data>tempB.data)
	            { tempB=tempB.next;}
	             connB=tempB.next;
	           tempB.next=tempA;
	           tempB=connB;
	        }
	        }
	      return headB; } 
	      
	             
	        
	        
	    }

	}
	
	
	void Print(hackerankll head) {
	    hackerankll temp=head;
	    if(temp==null){
	        System.out.println("");
	       }else{
	        while(!(temp==null)){
	            System.out.println(temp.data);
	            temp=temp.next;
	        }
	    }
	  
	  
	}

}
