
package ctcTreesAndGraphs;

import trees.TreesMethods;
import trees.*;

public class MillionNodes {
	static public void main(String[] args){
		TreesMethods input = new TreesMethods();
		TreesMethods input2 = new TreesMethods();
		input.add("tom",6);
		input.add("dad",4);
		input.add("mom",5);
		//input.add("pom",6);
		input.add("wqw", 3);
		input.add("pomqw",2);
		input.add("pomqw",9);
		checktree(input.root,input2.root);
	}
	
	static public boolean checktree(NodeTrees t1,NodeTrees t2){
	
		if(t2==null){
			return true;
		}else{return check(t1,t2);}
		
	}
	static public boolean check(NodeTrees t1,NodeTrees t2){
		
		boolean v1=false;
		boolean v2=false;
        if(t2.salary==t1.salary){
			
			if(subtree(t1,t2)){
				return true;
			}else{v1=check(t1.leftchild,t2.leftchild);
			     v2= check(t1.rightchild,t2.rightchild);
			                                     }
		}
        if(v1==true ||v2==true){
        	return true;
        }else{
		return false;}
	}
	
	static public boolean subtree(NodeTrees t1,NodeTrees t2){
		if(t1!=null &&t2!=null){	
		   if(t1.salary==t2.salary){
			   if(subtree(t1.leftchild,t2.leftchild) &&subtree(t1.rightchild,t2.rightchild)){
				   return true;}
			   }else{return false;}
		}else if(t1==null&&t2==null){
			return true;
		}else{return false;}
		return true;
	   }
}
