package programCreekMaths;
import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappyNumber(1));
	}
	
	static public boolean isHappyNumber(int input){
		HashSet<Integer> hmap=new HashSet<Integer>();
		if(!hmap.contains(input)){
			hmap.add(input);
		}else{return false;}
		int mod;
		int p=input;
		int result=0;
		while(p>0){
			mod=p%10;
			p=p/10;
			result=result+(mod*mod);
		}
		
		if(result==1){
			return true;
		}else{
			if(isHappyNumber(result)){return true;}}
		return false;
	}

}
