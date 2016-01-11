import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.util.LinkedList;





class SortByValue implements Comparator<Map.Entry<String, Integer>>{
	 
	   public int compare( Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
	        return (entry2.getValue()).compareTo( entry1.getValue() );
	   }
	}

public class project implements Comparable<project> {
	Integer docId;
	Integer termF;
    public project(Integer x, Integer y){
    	docId=x;
    	termF=y;
    }
    public int compareTo(project o) {
		
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
	public static void main(String[] args) throws IOException {
		
		File InputFile= new File("C:\\Users\\Nikhil\\Desktop\\1st Semester Courses\\IR\\Programming assignment\\term.idx");
 		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(InputFile)));
 		String line=null;
   	    HashMap<String, LinkedList<project> > hm = new HashMap<String, LinkedList<project>>();
 		while( (line = br.readLine())!= null ){
 			// for (String retval: line.split("\\\\",3)){
 			String[] retval=  line.split("\\\\",3);
 				 String a= retval[0];
 				 
 			  	String b= retval[2].substring(2,retval[2].length()-1);
 			  	Matcher m = Pattern.compile("(\\d+)/(\\d+)").matcher(b);
 			  	LinkedList<project> document= new LinkedList<project>();
				//LinkedList<Integer> term= new LinkedList<Integer>();
 			  	while(m.find()) {
 					  
 					  document.add(new project(Integer.parseInt(m.group(1)),Integer.parseInt(m.group(2))));
 					  
 			  	}
 			  		hm.put(a, document);
 		         }
		
// 		LinkedList<project> a= hm.get("accord");
// 		for(project o : a){
//		    System.out.println(o.docId);
//		}
		
		
		//getTopk(8); 
		//System.out.println("\n");
		//getPostings("Goldman Goldmine Goldsmith wqw",hm);
		termAtATimeQueryAnd("accord !DOCTYPE Aceh ",hm);
		
 
	}
	
	public static void termAtATimeQueryAnd(String k,HashMap<String, LinkedList<project>> hm) throws  IOException{
		String str=k;
		String[] splited = str.split("\\s+");
		ArrayList<String> splited1 = new ArrayList<String>();
		boolean present = true;
		for (String s:splited) {
			present = hm.containsKey(s);
			if (present) {
				splited1.add(s);
				
			}
			else {
				System.out.println("Term not found "+s);
				System.out.println("\n");
			}
		}
		HashMap<String, LinkedList<Integer> > taat = new HashMap<String, LinkedList<Integer>>();
		

		for(int i=0;i<splited1.size();i++) 
		{
		for (Map.Entry<String, LinkedList<project>> e : hm.entrySet()) {
				if (splited1.get(i).equals(e.getKey()))
				{// System.out.println(e.getKey());
					String key = e.getKey();
					LinkedList<Integer> taatV = new LinkedList<Integer>();
					Collections.sort(e.getValue(),Collections.reverseOrder());
					for (project l1:e.getValue()) {
						//System.out.println(l1.docId);
		 				taatV.add(l1.docId);
		 				
		 			}
						
					taat.put(key, taatV);
				}
		}
//		for (Map.Entry<String, LinkedList<Integer>> p2 : taat.entrySet()){
//			String Key=p2.getKey();
//			System.out.println(Key);
//			System.out.println(p2.getValue());
//		}

		LinkedList<Integer> a=taat.get(splited1.get(0));
		for(int kk=0;kk<taat.get(splited1.get(0)).size();kk++){
				a.add(taat.get(splited1.get(0)).get(kk));
				}
				for(Integer o : a){
				    System.out.println(o);
				}		
		for (int j=0;j<splited1.size();j++)//go across words
		{
			LinkedList<Integer> b=taat.get(splited1.get(j+1));
			
		
		//b.add(taat.get(splited1.get(j+1)));
		LinkedList<Integer> temp= new LinkedList<Integer>();
		
		for (int p=0;p<a.size();p++)
		{ 
		   for (int q=0;q<b.size();q++) 
		   { if (a.get(p)==b.get(q))
		      { 
		       temp.add(b.get(q));
		      }
		   }
		  
		}
		a=temp;
		temp.clear();
		
		}
		
		
		
		}
		
//		for (Map.Entry<String, LinkedList<Integer>> g : taat.entrySet()) {
//			String key=g.getKey();
//			System.out.println(key);
//			taatprint(g.getValue());
//			for (Integer p:g.getValue()) {
//				System.out.print(p.intValue()+", ");
//			
//		}
		
			
	}
	
//	 public static void taatprint(LinkedList<Integer> e)
//		{
//			for (Integer l1:e) {
//				System.out.print(l1.intValue() + ", ");
//			}
//			
//	     }
		//second query		
				
				
	public static void getPostings(String k,HashMap<String, LinkedList<project>> hm) throws  IOException{
		String str=k;
		String[] splited = str.split("\\s+");
		ArrayList<String> splited1 = new ArrayList<String>();
		boolean present = true;
		for (String s:splited) {
			present = hm.containsKey(s);
			if (present) {
				splited1.add(s);
			}
			else {
				System.out.println("Term not found "+s);
				System.out.println("\n");
			}
		}
		
		
			for(int i=0;i<splited1.size();i++) 
			{
			for (Map.Entry<String, LinkedList<project>> e : hm.entrySet()) {
					if (splited1.get(i).equals(e.getKey()))
					{
						String key = e.getKey();
					
		 		    System.out.println("FUNCTION: getPostings "+key+"\n");
		 		   Collections.sort(e.getValue(), new Comparator<project>(){
				        public int compare(project a, project b) {
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
		 		   Collections.sort(e.getValue(), Collections.reverseOrder());
		 		   System.out.print("Ordered by TF: ");
		 		   printList(e.getValue());
		 		   System.out.println("\n");
	 		   }
					}
		}
			}
		
	
	 
 		 public static void printList(LinkedList<project> e)
 		{
 			for (project l1:e) {
 				System.out.print(l1.docId + ", ");
 			}
 			
	     }
 		
	
	 public static void getTopk(int k) throws NumberFormatException, IOException{
   	  File InputFile= new File("C:\\Users\\Nikhil\\Desktop\\1st Semester Courses\\IR\\Programming assignment\\term.idx");
 		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(InputFile)));
 		String line=null;
   	  HashMap<String, Integer> hm = new HashMap<String, Integer>();
 		while( (line = br.readLine())!= null ){
 			// for (String retval: line.split("\\\\",3)){
 			String[] retval=  line.split("\\\\",3);
 				 String a= retval[0];
 				 //System.out.println(a);
 			  		int b= Integer.parseInt(retval[1].substring(1));
 			  		hm.put(a, b);
 		         } 
   	  Set<Entry<String, Integer>> entrySet = hm.entrySet();
         List<Entry<String, Integer>> listOfentrySet = new ArrayList<Entry<String, Integer>>(entrySet);
    
         
        
        
         Collections.sort(listOfentrySet, new SortByValue());
         int count=0;
	      Iterator i = listOfentrySet.iterator();
	      // Display elements
	      System.out.print("Result: ");
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey()+", ");
	       
	         count=count+1;
	         if (count==k)
	        	 break;
	      }
       // for(Map.Entry<String, Integer> entry:listOfentrySet)
        //System.out.print(entry.getKey());
      
		}
   }