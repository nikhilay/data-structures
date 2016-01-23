package trees;

public class MaximumSumOfTree {
 static int max=Integer.MIN_VALUE;
	
	static public int order(NodeTrees root){
		NodeTrees focusnode=root;
		int temp;
		if(focusnode!=null){
			int a=order(focusnode.leftchild);
			int b=order(focusnode.rightchild);
			int c=focusnode.salary+a+b;
			temp=max(a,b,c);
			if(max<temp){max=temp;}
			return c;
			      }else{return 0;}
		
		     }
	
	    static public int  max(int a, int b, int c){
	    	if(a>b){ 
				if(a>c){return a;
				      }else{return c;}
			    }else{
			    	if(b>c){
			    		return b;
			    		}else{ return c;}
			          }
	    }
	}

