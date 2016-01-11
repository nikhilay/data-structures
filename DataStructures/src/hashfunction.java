import java.util.Scanner;


public class hashfunction {
    private  String[] thearray;
    
    
	public static void main(String[] args) {
	Scanner hashsize = new Scanner(System.in);
	System.out.println("Please, enter the size of hashtable and also make sure it is prime number otherwise "
			+ "we would use the next minimum prime no");
	int test=hashsize.nextInt();
	hashsize.close();
	int correct;
	if (isprime(test)==true)
	{ correct=test;}
	else{correct=minprime(test);}
	
	String[] elementstobeadded={"21","24","3293","54","89","90","100","30","40","32","21"};
	hashfunction newhash = new hashfunction();
	newhash.thearray= new String[correct];
	newhash.hashfunction1(elementstobeadded, newhash.thearray, correct );
	newhash.display();
	newhash.find("2111",correct);
	}
	public void find(String key, int correct){
		
		int k=Integer.parseInt(key)%correct;
		if(thearray[k]==key){
		System.out.println(thearray[k]+" was found ");
		}
		else{System.out.print("Not in the hash table");}
		
	}
    public static boolean isprime(int test){
    	if (test%2==0)
    	{return false;}
    	else{ 
    		for(int i=3; i*i<test;i=i+2){
    	          if(test%i==0)
    	          {return false;}
    	       }
    	}
    	
    	return true;
    }
    
    public static int minprime(int test){
    	int p;
    	for (int i=test;true;i++){
    		if(isprime(i))
    		{	p=i;
    		break;}
    		
    	}
    	return p;
    }
	public void hashfunction1(String[] input, String[] hasharray, int hashlength){
		
		for( int i=0; i<input.length;i++){
			
			int l=Integer.parseInt(input[i])%hashlength;
			hasharray[l]=input[i];
				}
	
	}
	
	public void display(){
		for(int i=0;i<thearray.length;i++){
		System.out.print(thearray[i]+" ");
		}
		System.out.print("\n");
	}
	
}	
	

