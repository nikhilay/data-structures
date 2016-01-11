
public class queue {
    private int queuesize;
    private String[] queue;
    private int front,nuofitems,rear=0;
    
    queue(int size)
    {
     queuesize=size;
     queue= new String[queuesize];
    }
    
    public void insert(String input){
    	if (rear<queuesize)
    	{queue[rear]=input;
    	rear++;
    	nuofitems++;}else
    	{System.out.print("Sorry, queue is full");}
    }
    
    public void remove(){
    	if (nuofitems>0)
    	{ System.out.println(queue[front] +" is removed");
    		queue[front]="-1";
    	  front++;
    	  nuofitems--;
    	}else {System.out.println("Sorry, queue is empty");}
    }
    public void display(){
    	for(int i=front; i<queuesize;i++)
    	{System.out.print(queue[i]+" ");}
    	System.out.print("\n");
    }
	
	public static void main(String[] args) {
	 queue test= new queue(2);
	 test.insert("10");
	 test.insert("120");
	 test.display();
	 test.remove();
	 test.display();
	 test.remove();
	 test.remove();
	}

}
