package trees;

public class diameter {

	
	static public int width(NodeTrees root){
		NodeTrees focusnode=root;
		if (focusnode==null){
			return 0;
		}else if (focusnode.leftchild==null && focusnode.rightchild==null){
			return 1;
		}else{
			   int value1=treeDepth(focusnode.leftchild)+ treeDepth(focusnode.rightchild)+ 1;
			   int value2=width(focusnode.leftchild);
			   int value3=width(focusnode.rightchild);
			   
			   int temp=value1;
			   
			   if(temp>value2){
				   if(temp>value3){
					   return temp;
				   }else{return value3;}
			   }else{
				   temp=value2;
				   if(temp>value3){
					   return temp;
				   }else{return value3;}
			   }
			   
			   
		}
		
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
