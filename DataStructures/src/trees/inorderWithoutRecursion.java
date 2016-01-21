package trees;
import java.util.*;

public class inorderWithoutRecursion {

	
	static public void inorderstack(NodeTrees root){
		NodeTrees focusnode=root;
		NodeTrees temp;
		Stack<NodeTrees> inp= new Stack<NodeTrees>();
		if(focusnode!=null){
		inp.add(focusnode);
		while(focusnode.leftchild!=null){
			focusnode=focusnode.leftchild;
			inp.add(focusnode);
		}
		}else{return;}
		
		while(!inp.isEmpty()){
		temp=inp.pop();
		if(temp.rightchild==null){
		      System.out.print(temp.salary+" ");
		   }else{
			   System.out.print(temp.salary+" ");
			   temp=temp.rightchild;
			   inp.add(temp);
		    while(temp.leftchild!=null){
		    	temp=temp.leftchild;
				inp.add(temp);
			 }
		   }
		}
	
	}
		
	
	
}
