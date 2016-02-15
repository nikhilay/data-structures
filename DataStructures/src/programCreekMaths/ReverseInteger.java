package programCreekMaths;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Integer q=-100;

 reverseInt(q);
	}
 
	static public void reverseInt(Integer input){
		boolean flag=false;
		if(input<0){
			input=0-input;
			flag =true;
		}
		int res = 0;
		int p = input;
	 
		while (p > 0) {
			int mod = p % 10;
			p = p / 10;
			res = res * 10 + mod;
		}
	 if(flag==true){
		 System.out.println((0-res));
	 }else{System.out.println(res);}
		
	}

	
}
