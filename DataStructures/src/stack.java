
public class stack {
	private int stacksize;
	private int topofthestack=-1;
	private String[] stackarray;
	
	stack(int size)
	{
		stacksize=size;
		
		stackarray= new String[stacksize];
	}
	public void push( String input)
	{ if(topofthestack+1<stacksize)
	   {
		stackarray[topofthestack+1]=input;
		
		topofthestack++;
		System.out.println(input+" has been added at " + topofthestack);
	   }else
	     {System.out.println("Sorry, stack is full!!");}
	}
	
	public String pop(){
		String temp=stackarray[topofthestack];
		if(topofthestack>=0)
		{
			stackarray[topofthestack]="-1";
		   topofthestack--;
		   
		}else{System.out.println("Sorry, stack is empty!!");
		return "-1";}
		
		return temp;
		}
	
	public String peek(){
	return stackarray[topofthestack];
	}
	
	public void popall(){
		for (int i=topofthestack; i>=0;i--)
		{ pop();}
	}
	
	public void displaythestack(){
		for (int i=topofthestack; i>=0;i--)
		{ System.out.print(stackarray[i]+" ");}
		System.out.print("\n");
		
	}
	public static void main(String[] args) {
		stack firststack= new stack(10);
		firststack.push("10");
		firststack.push("12");
		firststack.push("9");
		firststack.displaythestack();
		System.out.print(firststack.peek()+ " is the top of the stack value");
		
		//firststack.displaythestack();


	}

}
