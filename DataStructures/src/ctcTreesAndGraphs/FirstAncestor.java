package ctcTreesAndGraphs;
import trees.*;

public class FirstAncestor {
	static public void main(String[] args){
	
		TreesMethods input = new TreesMethods();
		input.add("tom",10);
		input.add("dad",5);
		input.add("mom",3);
		//input.add("pom",6);
		input.add("wqw", 2);
		input.add("wqw", 1);
		input.add("wqw", 4);
		input.add("pomqw",6);
		input.add("pomqw",8);
		firstAncest(input.root,4,90);
	}
	
	   static public void firstAncest(NodeTrees root, int node1, int node2){
		   boolean IsNode1InLeftTree=false;
		   boolean IsNode2InRightTree=false;
		   boolean IsNode2InLeftTree=false;
		   boolean IsNode1InRightTree=false;
		if(root==null){
			System.out.println(" Trees is Empty !!");
			return;
		}else{
			IsNode1InLeftTree=findNode(root.leftchild,node1);
			IsNode2InRightTree=findNode(root.rightchild,node2);
			IsNode2InLeftTree=findNode(root.leftchild,node2);
			IsNode1InRightTree=findNode(root.rightchild,node1);
			if((root.salary==node1 &&(IsNode2InRightTree||IsNode2InLeftTree))||(root.salary==node2&&(IsNode1InLeftTree||IsNode1InRightTree))){
				System.out.println(" First Common ancestor is "+root.salary);
				return;
			}else if((IsNode1InLeftTree && IsNode2InRightTree)||(IsNode2InLeftTree &&IsNode1InRightTree)){
				System.out.println(" First Common ancestor is "+root.salary);
				return;
			}else if(IsNode1InLeftTree&&IsNode2InLeftTree){
				firstAncest(root.leftchild,node1,node2);
			}else if(IsNode2InRightTree&&IsNode1InRightTree){
				
				firstAncest(root.rightchild,node1,node2);
			}else{
				System.out.println(" Elements not found ");
				return;
			}
			
		}
	
		
	   }
	   
	   static public boolean findNode(NodeTrees root, int node){
		   if(root!=null){
		       if(root.salary==node){
			     return true;
		        }else{
			      if(findNode(root.leftchild,node)||findNode(root.rightchild,node)){
			    	  return true;
			      }
			      
		       }
		   }else{return false;}
		   return false;
	   }
}
