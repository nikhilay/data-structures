
package ctcTreesAndGraphs;
import trees.*;


public class CheckIfBinaryTreesBal {
	
	static public void main(String[] args){
		TreesMethods input = new TreesMethods();
		input.add("tom",6);
		input.add("dad",4);
		input.add("mom",5);
		//input.add("pom",60);
		input.add("wqw", 3);
		input.add("pomqw",2);
		//input.add("pomqw",5);
		//input.add("pomqw",1);
		//input.add("wqqwqww", 90);
		check(input.root);
	}
	
	static public void check(NodeTrees root){
		NodeTrees focusnode=root;
		int temp=height(focusnode);
		if(temp==-1){
			System.out.println(" Tree is not balanced");
		}else{
			System.out.println(" Tree is  balanced");
		}

		}
	
	static public int height(NodeTrees root){
		NodeTrees focusnode=root;
		int max1,max2;
		if(focusnode==null){
			return 0;
		}
		 max1 =height(focusnode.leftchild);
		 max2= height(focusnode.rightchild);
	  if( max1==-1|| max2==-1 ){
		  return -1;
	  }
		       if((max1-max2<2) &&(max1-max2>-2)){
		        if(max1>max2){
		        	return max1+1;
		        }else{
		        	return max2+1;
		        }
		       }else{
		    	   return -1; 
                 }
		  }	
	}


