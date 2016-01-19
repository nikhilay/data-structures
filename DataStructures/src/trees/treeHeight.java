package trees;

public class treeHeight {


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
