package linkedlist;

public class linkedListNode {

		public String bookname;
		public int millionSold;
		
		public linkedListNode next;
		
		linkedListNode(String bookname, int millionsold){
			
			this.bookname= bookname;
			this.millionSold= millionsold;
			
		}
		
		public void display(){
			System.out.println("book is :" + bookname+" and millionsold :" + millionSold);
		}
		

	

}
