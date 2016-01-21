package trees;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidth {
	static int max=0;
	
static public void widthLevel(NodeTrees root){
	  NodeTrees focusnode=root;
	  NodeTrees temp;
	  Queue<NodeTrees> inp = new LinkedList<NodeTrees>();
	  if(focusnode!=null){
	      inp.add(focusnode);
	      
	      while(!inp.isEmpty()){
		     temp=inp.remove();
		     max=max+1;
		     System.out.print(temp.salary +" ");
		     if(temp.leftchild!=null){
		       inp.add(temp.leftchild);}
		     if(temp.rightchild!=null){
		    inp.add(temp.rightchild);}  
       }
	  }
  }
}
