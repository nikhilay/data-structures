package ctcStacksAndQueues;

public class MinInO1CTCStacks extends NodeMethods{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinInO1CTCStacks list1= new MinInO1CTCStacks();
		list1.push(7);
		
	}
	
	public void push(int value){
		int newmin=Math.min(value, mini(this));
		super.insertFirst(value, newmin);
		}
	
	static public int mini(MinInO1CTCStacks temp){
		
		if(temp.isEmpty()){
			return Integer.MAX_VALUE;
			
		}else{
			int val=temp.peek();
			return val;
		}
	 }

}
