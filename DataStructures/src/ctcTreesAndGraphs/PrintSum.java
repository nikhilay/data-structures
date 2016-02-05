package ctcTreesAndGraphs;
import trees.*;
public class PrintSum {
	static public void main(String[] args){
		int sum=15;
		int[] path=new int[4];
		int level=0;
		TreesMethods input = new TreesMethods();
		input.add("tom",6);
		input.add("dad",4);
		input.add("mom",5);
		//input.add("pom",6);
		input.add("wqw", 3);
		input.add("pomqw",2);
		//input.add("pomqw",5);
		findpath(input.root,sum,path,level);
	}
	
	static public void findpath(NodeTrees root,int sum, int[] path, int level){
		if(root==null){
			return;
		}else if(root.salary==sum){
			path[level]=root.salary;
			print(path,level);
			return;
		}else{path[level]=root.salary;
		level++;
		//if(root.leftchild!=null){
		findpath(root.leftchild,sum-root.salary, path,level);
		//if(root.rightchild!=null){
		findpath(root.rightchild,sum-root.salary,path, level);
			
		}
		
	 }
	
	static public void print(int[] path, int level){
		for(int i=0;i<=level;i++){
			System.out.print(path[i]+" ");
		}
		System.out.print("\n");
	 
	}
	
}


