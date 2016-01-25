package ctcStacksAndQueues;

public class ArrayStacks {
	int topofthestack=0;
	int[] a= new int[6];
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStacks as= new ArrayStacks();
		as.push(5);
		System.out.println(as.topofthestack);
		
	//push
	//pop
	//peek
	//isempty

	}
	
	public void isEmtpy(){
		if(topofthestack<0){
			System.out.println(" Empty List ");
		}else{
			System.out.println(" Not an Empty List ");
		}
	 }
     
     public void push(int d){
    	if(topofthestack<a.length){
    	  
    	  a[topofthestack]=d;
    	  topofthestack++;
    	  
    	} else{System.out.println(" Stack is full");}
     }
     
     public void peep(){
    	 if(topofthestack>=0){
        	  System.out.println(a[topofthestack]+" is the element ");
        	} else{System.out.println(" Stack is empty");}
      }
	
     public int pop(){
     	if(topofthestack>=0){
     		int temp=a[topofthestack];
     	  System.out.println(a[topofthestack]+" is the element ");
     	  topofthestack--;
     	  return temp;
     	} 
     	return null;
      }
}
