package testing;



import java.util.Collections;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.*;
import java.util.LinkedList;


public class testing implements Comparable<testing> {
	Integer docId;
	Integer termF;
    public testing(Integer x, Integer y){
    	docId=x;
    	termF=y;
    }
    

     public int compareTo(testing o) {
        			
    		 int comparedSize = o.termF;
    		 if (this.termF > comparedSize) {
    			return 1;
    		 } else if (this.termF == comparedSize) {
    			return 0;
    		 } else {
    			return -1;
    		   }
        	
	
    	}
     
    	public Integer toInteger() {
    		return docId;
    	}
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		File InputFile= new File("C:\\Users\\Nikhil\\Desktop\\1st Semester Courses\\IR\\Programming assignment\\term.idx");
 		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(InputFile)));
 		String line=null;
   	  HashMap<String, LinkedList<testing> > hm = new HashMap<String, LinkedList<testing>>();
 		while( (line = br.readLine())!= null ){
 			// for (String retval: line.split("\\\\",3)){
 			String[] retval=  line.split("\\\\",3);
 				 String a= retval[0];
 				 
 			  	String b= retval[2].substring(2,retval[2].length()-1);
 			  	Matcher m = Pattern.compile("(\\d+)/(\\d+)").matcher(b);
 			  	LinkedList<testing> document= new LinkedList<testing>();
				//LinkedList<Integer> term= new LinkedList<Integer>();
 			  	while(m.find()) {
 					  
 					  document.add(new testing(Integer.parseInt(m.group(1)),Integer.parseInt(m.group(2))));
 					  
 			  	}
 			  		hm.put(a, document);
 		         } 
 		for (Map.Entry<String, LinkedList<testing>> e : hm.entrySet()) {
 		    String key = e.getKey();
 		    System.out.println("FUNCTION: getPostings "+key+"\n");
 		    
 		   Collections.sort(e.getValue(), new Comparator<testing>(){
		        public int compare(testing a, testing b) {
		        	if (b.docId < a.docId)
		        		  return 1;
		        		else if (b.docId > a.docId)
		        		  return -1;
		        		else
		        		  return 0;
		        }
		    });
 		  System.out.print("Ordered by doc IDs: ");
 		  printList(e.getValue());
 		  System.out.print("\n");
 		  
// 		    for (testing x : e.getValue())
//  		      System.out.print(x.docId + ", ");
//  		    System.out.print("\n");
  		  
  		    //Print of "ordered by term frequency" 
 		   Collections.sort(e.getValue(), Collections.reverseOrder());
 		  
 		   System.out.print("Ordered by TF: ");
 		   printList(e.getValue());
 		   System.out.println("\n");
 		  
 		 
 		}
 		    
 		}
 		public static void printList(LinkedList<testing> e) {
 			for (testing l1:e) {
 				System.out.print(l1.docId+ ", ");
 			}
 			
 	        }
		
		}

	
	


