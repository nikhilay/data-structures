package trees;

public class printAncestors {
	
     static public boolean ancestors(NodeTrees root,int key){
	  NodeTrees focusnode=root;
	
	if (focusnode==null){
		return false;
	  }else{
              if(focusnode.salary==key){
    	         return true;
                 }else
                    { 
                	   boolean var1=ancestors(focusnode.leftchild,key);
                       boolean var2=ancestors(focusnode.rightchild,key);
                       if(var1==true){
            	         System.out.print(focusnode.salary+" ");
            	        return true;
                         } else if(var2==true){
            	            System.out.print(focusnode.salary+" ");
            	            return true;
                        }
                       return false;
                     }
	         }
        }
}
