import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no");
        int arraylength= sc.nextInt();
        while(constraintone(arraylength)==false){
            System.out.println("Please enter a number between 1 and 1000");
            arraylength= sc.nextInt();

        }
        sc.nextLine();
        boolean p=false;
       int[] realarray;
        do
        { System.out.println("Enter the array no");
  	    String inputnos=sc.nextLine();
        String[] arrayinput=inputnos.split("\\s");
         realarray=new int[arrayinput.length];
              for(int i=0;i<arrayinput.length;i++){
            	  realarray[i]=Integer.parseInt(arrayinput[i]);
            	  if (constraintTwo(realarray[i])==false){
            		  System.out.println("Please enter each number between 1 and 10000");
            		  p=false;
            	  break;
            	  }
            	  p=true;
              }
              if(arraylength==realarray.length){p=true;}else{p=false;}
             
        } while(p==false);
        sc.close();
        String t=" ";
        for(int k=realarray.length-1;k>=0;k--)
        {
        	t=t+realarray[k]+" ";}
        System.out.print(t.trim());
        }
      
    

    
    public  static boolean constraintTwo(int inp){
        if(!(inp>=1 && inp<=10000)){
            return false;
        }else{ return true;}
    }
    
    
    public  static boolean constraintone(int arrayl){
        if(!(arrayl>=1 && arrayl<=1000)){
            return false;
        }else{ return true;}
    }
}