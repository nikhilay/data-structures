package bloomberg;

//Problem        : Excel Wizard
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
  public static void main(String[] args)
  {

     Scanner stdin = new Scanner(System.in);
     int i=0;
     int n=0;
     char str []=null;
     while(stdin.hasNextLine()) 
     {
    	 n=Integer.parseInt(stdin.nextLine());
    	
    	    int rem = n%26;
    	   // System.out.println(rem);
            // If remainder is 0, then a 'Z' must be there in output
            if (rem==0)
            {
                str[i++] = 'Z';
                n = (n/26)-1;
                break;
            }
//            else // If remainder is non-zero
//            {
//                str[i++] =  (char) ((rem-1)+'A');
//                n = n/26;
//            }
            
    }
     str[i] = '\0';
     System.out.println(str);
   
         stdin.close();
        }

  
}
     
  


