package trees;

public class NodeTrees {
    
	int salary;
	String name;
	NodeTrees leftchild,rightchild;
	
	NodeTrees(int value, String name){
		this.name=name;
		salary=value;
		leftchild=null;
		rightchild=null;
	}

	NodeTrees(){
		
		
		leftchild=null;
		rightchild=null;
	}
}