package trees;

public class KdistanceFromRoot {
	
	static public void kNode(NodeTrees root, int d){
		NodeTrees focusnode=root;
		int h= treeHeight.treeDepth(focusnode);
		if(d+1<=h && focusnode!=null){
		     
		    	 getelements(focusnode,d+1);
		    	 
		     
		}
	}
	
	static public void getelements(NodeTrees focusnode, int d){
		 if(d==1){
			 System.out.print(focusnode.salary+" ");
		 }else{ 
			 if(focusnode.leftchild!=null){
			     getelements(focusnode.leftchild,d-1);}
			 if(focusnode.rightchild!=null){ getelements(focusnode.rightchild,d-1);}
		 
		 }
		
	}

}
