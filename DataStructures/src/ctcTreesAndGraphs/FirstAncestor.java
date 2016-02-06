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
		   boolean check1=false;
		   boolean check2=false;
		   boolean check3=false;
		   boolean check4=false;
		if(root==null){
			System.out.println(" Trees is Empty !!");
			return;
		}else{
			check1=findNode(root.leftchild,node1);
			check2=findNode(root.rightchild,node2);
			check3=findNode(root.leftchild,node2);
			check4=findNode(root.rightchild,node1);
			if((root.salary==node1 &&(check2||check3))||(root.salary==node2&&(check1||check4))){
				System.out.println(" First Common ancestor is "+root.salary);
				return;
			}else if((check1 &&check2)||(check3 &&check4)){
				System.out.println(" First Common ancestor is "+root.salary);
				return;
			}else if(check1&&check3){
				firstAncest(root.leftchild,node1,node2);
			}else if(check2&&check4){
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
