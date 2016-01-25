package ctcStacksAndQueues;

public class ThreeStacks {

	int[] a= new int[6];
	int topofthestack1=-1;
	int topofthestack2=a.length/3-1;
	int topofthestack3=(2*a.length/3)-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeStacks as= new ThreeStacks();
		as.push(1,1);
		as.push(1,2);
		as.push(2,1);
		as.push(2,2);
		as.push(3,1);
		as.push(3,2);
		as.push(3,9);
		
        
	}
	
	public void isEmtpy(int stkno){
		if((stkno-1)==0){
		   if(topofthestack1<0){
			   System.out.println("Stack "+stkno+" is an Empty List ");
		    }else{
			   System.out.println("Stack "+stkno+" Not an Empty List ");
		    }
		}else if((stkno-1)==1){
			if(topofthestack2<a.length/3){
				   System.out.println("Stack "+stkno+" is an Empty List ");
			    }else{
				   System.out.println("Stack "+stkno+" Not an Empty List ");
			    }
		}else if((stkno-1)==2){
			if(topofthestack3<2*a.length/3){
				   System.out.println("Stack "+stkno+" is an Empty List ");
			    }else{
				   System.out.println("Stack "+stkno+" Not an Empty List ");
			    }
		}
		
	 }
	
	  public void push(int stkno,int d){
		  if((stkno-1)==0){
	    	if(topofthestack1<a.length/3-1){
	    	   topofthestack1++;
	    	  a[topofthestack1]=d;
	    	   
	    	 } else{System.out.println(" Stack is full for "+d+" in Stack"+stkno);}
		  }else if((stkno-1)==1){
			  if(topofthestack2<2*a.length/3-1){
				  topofthestack2++;
		    	  a[topofthestack2]=d;
		    	   
		    	 } else{System.out.println(" Stack is full for "+d+" in Stack"+stkno);} 
			  
		  }else if((stkno-1)==2){
			  if(topofthestack3<a.length-1){	    	    
		    	  a[topofthestack3]=d;
		    	  topofthestack3++; 
		    	 } else{System.out.println(" Stack is full for "+d+" in Stack"+stkno);}
		  }
	    	
	    }
	     
	  public void peep(int stkno){
		  if((stkno-1)==0){
			  if(topofthestack1>=0){
	        	  System.out.println(a[topofthestack1]+" is the element in Stack "+stkno);
	        	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
		  }else if((stkno-1)==1){
			  if(topofthestack2>=a.length/3){
	        	  System.out.println(a[topofthestack2]+" is the element in Stack "+stkno );
	        	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
			  
		  }else if((stkno-1)==2){
			  if(topofthestack3>=2*a.length/3){
	        	  System.out.println(a[topofthestack3]+" is the element in Stack "+stkno );
	        	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
		  }
	    	
	    }
	  
	  public void pop(int stkno){
		  if((stkno-1)==0){
			  if(topofthestack1>=0){
		     	  System.out.println(a[topofthestack1]+" is the element in Stack "+stkno);
		     	  topofthestack1--;
		     	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
		  }else if((stkno-1)==1){
			  if(topofthestack2>=a.length/3){
		     	  System.out.println(a[topofthestack2]+" is the element in Stack "+stkno);
		     	  topofthestack2--;
		     	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
			  
		  }else if((stkno-1)==2){
			  if(topofthestack3>=2*a.length/3){
		     	  System.out.println(a[topofthestack3]+" is the element in Stack "+stkno);
		     	  topofthestack3--;
		     	} else{System.out.println("Stack "+stkno+" is an Empty List ");}
		  }
	    	
	    }
	
	

}
