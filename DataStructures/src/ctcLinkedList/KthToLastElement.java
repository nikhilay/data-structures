package ctcLinkedList;

public class KthToLastElement {
// Solution 1...using string length and subtracting it from k

	public int kRecursive(Node firstnode, int k){
		Node curr=firstnode;
		if(curr==null){
			System.out.println(" Empty List ");
			return 0;
		}
		if(curr.next==null){
			return 0; 
		}else{
			int a=kRecursive(curr.next,k);
			if(k==a){
				System.out.println(" Element is "+ curr.data);
			}
			return a+1;
		}
		
	}
}
