package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class checkSubtree {

	static public void check(NodeTrees root1,NodeTrees root2){
		int a=treeDepth(root1);
		int b=treeDepth(root2);
		NodeTrees smalltree,largetree,temp;
		NodeTrees match;
		if(a>b){smalltree=root2;largetree=root1;}else{smalltree=root1;largetree=root2;}
	   if(find(largetree,smalltree)!=null){
		   check1(smalltree,find(largetree,smalltree));
	   }else{System.out.println("No match");}
		  
	}
	
	static public NodeTrees find(NodeTrees largetree,NodeTrees smalltree){
		NodeTrees temp,match=null;
		
		 Queue<NodeTrees> inpL = new LinkedList<NodeTrees>();
		  if(largetree!=null){
		      inpL.add(largetree);
		      while(!inpL.isEmpty()){
			     temp=inpL.remove();
			     if(temp==smalltree){match=temp;return match;}
			     if(temp.leftchild!=null){
			       inpL.add(temp.leftchild);}
			     if(temp.rightchild!=null){
			    inpL.add(temp.rightchild);}  
	         }
		      System.out.print("Not a Sub Tree !!");
		  }
		  return match;
	}
	
	 static public boolean check1(NodeTrees smalltree,NodeTrees largetree){
		  NodeTrees focusnodeS=smalltree;
		  NodeTrees focusnodeL=largetree;
		  NodeTrees tempS;
		  NodeTrees tempL;
		  Queue<NodeTrees> inpS = new LinkedList<NodeTrees>();
		  Queue<NodeTrees> inpL = new LinkedList<NodeTrees>();
		  if(focusnodeS!=null && focusnodeL!=null){
		      inpS.add(focusnodeS);
		      inpL.add(focusnodeL);
		      while(!inpS.isEmpty() && !inpL.isEmpty()){
			     tempS=inpS.remove();
			     tempL=inpL.remove();
			    if(tempS==tempL){
			     //System.out.print(temp.salary +" ");
			     if(tempS.leftchild!=null&&tempL.leftchild!=null){
			           inpS.add(tempS.leftchild);
			           inpL.add(tempL.leftchild);
			        }else{return false;}
			     if(tempS.rightchild!=null&&tempL.leftchild!=null){
			                 inpS.add(tempS.rightchild);
			                 inpL.add(tempL.rightchild);
			                   }  else{return false;}
			     }else{return false;}
	           }
		      return true;
		  }else{return false;}
		  //return true;
	    }
	
	
	
	
	
	
	
	
	static public int treeDepth(NodeTrees root){
		NodeTrees focusnode;
		focusnode=root;
		int max1,max2;
		if(focusnode==null){
			return 0;
		}
		if(focusnode.leftchild==null &&focusnode.rightchild==null){
			return 1;
		  }else{ max1 =treeDepth(focusnode.leftchild);
		       max2= treeDepth(focusnode.rightchild);
		       
		        if(max1>max2){
		        	return max1+1;
		        }else{
		        	return max2+1;
		        }
            }
         }
}
