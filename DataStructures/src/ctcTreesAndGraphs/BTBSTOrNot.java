package ctcTreesAndGraphs;
import trees.*;

public class BTBSTOrNot {
	
	static public void main(String[] args){
		TreesMethods input = new TreesMethods();
		input.add("tom",25);
		input.add("dad",55);
		input.add("mom",45);
		input.add("pom",60);
		input.add("wqw", 20);
		input.add("pomqw",10);
		
		input.add("wqqwqww", 90);
		checkBST(input.root);
	}
	static public void checkBST(NodeTrees root){
		if(root!=null){
		int temp=bst(root);
		if(temp==1){System.out.println(" It is a balanced search tree !!");
		} else if(temp==-1){System.out.println(" It is not balanced search tree !!");}
		}
	}

	static public int bst(NodeTrees root){
		NodeTrees focusnode=root;
		if(focusnode==null){return 1;}
		if(focusnode.leftchild==null&& focusnode.rightchild==null){
		        return 1;}
		
		int temp1=bst(focusnode.leftchild);
		int temp2=bst(focusnode.rightchild);
		if(focusnode.rightchild!=null&&focusnode.leftchild!=null&&focusnode.leftchild.salary<focusnode.salary && focusnode.rightchild.salary>focusnode.salary&&temp1==1&&temp2==1){
			return 1;
		}else if(focusnode.rightchild==null&&focusnode.leftchild.salary<focusnode.salary&&temp1==1&&temp2==1){
			return 1;
		}else if(focusnode.leftchild==null&&focusnode.rightchild.salary>focusnode.salary&&temp1==1&&temp2==1){
			return 1;
		}
		
		else{
			return -1;
		}
		
		  
		}
	
    
}
