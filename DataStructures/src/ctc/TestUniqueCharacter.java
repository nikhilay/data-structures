package ctc;

public class TestUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="";
		check(str);
	}
	
	static public void check(String str){
      if(str.length()==0){
    	  System.out.println(" No word has been entered");
    	  return;
      }
      //should I use small ro capitaal Char
      char[] a=str.toLowerCase().toCharArray();
      boolean[] b= new boolean[26];
      
      for(int i=0;i<a.length;i++){
    	   char c=a[i];
    	   int position=(int) c-(int) 'a';
    	  // int position=str.charAt(i);
    	   if(b[position]==true){
    		   System.out.println("Does not have unique characters");
    		   return;
    		   
    	      }
    	   b[position]=true;
      }
      System.out.println("Have unique characters");
		
		
	}

}
