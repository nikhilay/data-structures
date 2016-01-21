package trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 static public void levelOrderTraverse(NodeTrees root){
		  NodeTrees focusnode=root;
		  NodeTrees temp;
		  Queue<NodeTrees> inp = new LinkedList<NodeTrees>();
		  if(focusnode!=null){
		      inp.add(focusnode);
		      while(!inp.isEmpty()){
			     temp=inp.remove();
			    
			     System.out.print(temp.salary +" ");
			     if(temp.leftchild!=null){
			       inp.add(temp.leftchild);}
			     if(temp.rightchild!=null){
			    inp.add(temp.rightchild);}  
	         }
		  }
	    }
}
