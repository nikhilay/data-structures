package trees;

public class NodeTrees {
    
	public int salary;
	public String name;
	public NodeTrees leftchild,rightchild;
	
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
