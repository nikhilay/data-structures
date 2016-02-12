package programCreek;
import java.util.*;

public class IsmorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(checkIsomorphic("egg","aer"));
	}
	
	static public boolean checkIsomorphic(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}else{ HashMap<Character,Character> hmap= new HashMap<Character,Character>();
			   for(int i=0;i<s1.length();i++){
				   if(hmap.get(s1.charAt(i))!=null&&hmap.get(s1.charAt(i))!=s2.charAt(i)){
					   return false;
				   }
				   hmap.put(s1.charAt(i), s2.charAt(i));
			   }
			   return true;
		}
	}

}
