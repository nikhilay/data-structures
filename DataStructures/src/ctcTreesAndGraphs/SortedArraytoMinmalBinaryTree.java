package ctcTreesAndGraphs;
import trees.*;

public class SortedArraytoMinmalBinaryTree {
	static public void main(String[] args){
	int[] b={1,2,3,4,5,6,7};
	TreesMethods input = new TreesMethods();
	convert(b,input,0,b.length-1);
	levelOrder.levelOrderTraverse(input.root);
	}
	static public void convert(int[] a,TreesMethods  focusnode, int l, int u){
		int mid;
		mid=((u-l)/2+l);
		
			//focusnode.add("w",a[l+mid]);
			if(u==l){
				focusnode.add("w",a[u]);
				return;
			}
    //System.out.print(a[mid]+" ");
		focusnode.add("w",a[mid]);
		convert( a,focusnode,l,mid-1);
		convert( a,focusnode,mid+1,u);
	 	
	}
	}

