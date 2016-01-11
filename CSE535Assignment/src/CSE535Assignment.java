

//import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.regex.*;
import java.util.LinkedList;

class SortByValue implements Comparator<Map.Entry<String, Integer>> {

	public int compare(Map.Entry<String, Integer> entry1,
			Map.Entry<String, Integer> entry2) {
		return (entry2.getValue()).compareTo(entry1.getValue());
	}
}

public class CSE535Assignment implements Comparable<CSE535Assignment> {
	Integer docId;
	Integer termF;

	public CSE535Assignment(Integer x, Integer y) {
		docId = x;
		termF = y;
	}

	public int compareTo(CSE535Assignment o) {

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

	static String kterms;

	// static String bonusline;
	// static PrintWriter System.out;
	public static void main(String[] args) throws IOException {

		// PrintStream out = new PrintStream(new FileOutputStream(args[1]));
		// System.setOut(out);

		// System.out.println(args[2]);
		// System.out= new PrintWriter(args[1]);
		File file = new File(args[1]);
		FileWriter writer = new FileWriter(file);
		StringBuilder sb = new StringBuilder();
		kterms = args[0];
		int p1 = Integer.parseInt(args[2]);
		File InputFile = new File(args[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(InputFile)));
		String line = null;
		HashMap<String, LinkedList<CSE535Assignment>> hm = new HashMap<String, LinkedList<CSE535Assignment>>();
		while ((line = br.readLine()) != null) {
			// for (String retval: line.split("\\\\",3)){
			String[] retval = line.split("\\\\", 3);
			String a = retval[0];

			String b = retval[2].substring(2, retval[2].length() - 1);
			Matcher m = Pattern.compile("(\\d+)/(\\d+)").matcher(b);
			LinkedList<CSE535Assignment> document = new LinkedList<CSE535Assignment>();
			// LinkedList<Integer> term= new LinkedList<Integer>();
			while (m.find()) {

				document.add(new CSE535Assignment(Integer.parseInt(m.group(1)),
						Integer.parseInt(m.group(2))));

			}
			hm.put(a, document);
		}
		HashMap<String, LinkedList<CSE535Assignment>> postinghm = new HashMap<String, LinkedList<CSE535Assignment>>();
		postinghm.putAll(hm);
		File termFile = new File(args[3]);
		BufferedReader tf = new BufferedReader(new InputStreamReader(
				new FileInputStream(termFile)));
		int p2 = 0;
		String line1 = null;

		while ((line1 = tf.readLine()) != null) {
			String tfline = line1;
			String[] postline = tfline.split("\\\\");

			if (p2 < 1) {
				sb.append(getTopk(p1));
			}
			for (int p3 = 0; p3 < postline.length; p3++) {
				sb.append(getPostings(postline[p3], postinghm));
			}
			sb.append("\n");
			sb.append(termAtATimeQueryAnd(tfline, hm));
			
			System.out.print("\n");
			sb.append("\n");
			
			sb.append(termAtATimeQueryOr(tfline, hm));
			System.out.print("\n");
			sb.append("\n");
			sb.append(docAtATimeQueryAnd(tfline, postinghm));
			System.out.print("\n");
			sb.append("\n");
			sb.append(docAtATimeQueryOr(tfline, postinghm));
			p2 = p2 + 1;
		}

		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}

	public static String docAtATimeQueryOr(String k,
			HashMap<String, LinkedList<CSE535Assignment>> hm)
			throws IOException {
		String result="";
		long startTime1 = System.currentTimeMillis();
		String str3 = k;
		int total = 0;
		LinkedList<Integer> finallist = new LinkedList<Integer>();
		String[] splited3 = str3.split("\\s+");
		ArrayList<String> splited33 = new ArrayList<String>();
		boolean present = true;
		for (String s : splited3) {
			present = hm.containsKey(s);
			if (present) {
				splited33.add(s);

			} else {
				System.out.println("FUNCTION: DocumentAtATimeQueryOr: Term not found " + s);
				result +="FUNCTION: DocumentAtATimeQueryOr: Term not found " + s;
				// System.out.println("\n");
			}
		}
		HashMap<String, LinkedList<Integer>> daat = new HashMap<String, LinkedList<Integer>>();
		for (int p9 = 0; p9 < splited33.size(); p9++) {
			LinkedList<Integer> daatV = new LinkedList<Integer>();
			LinkedList<CSE535Assignment> p = hm.get(splited33.get(p9));
			for (CSE535Assignment l1 : p) {
				// System.out.println(l1.docId);
				daatV.add(l1.docId);

			}
			daat.put(splited33.get(p9), daatV);

		}
		LinkedList<Integer> a = daat.get(splited33.get(0));

		if (splited33.size() == 1) {
			System.out.println("FUNCTION: DocumentAtATimeQueryOr " + str3);
			result +="FUNCTION: DocumentAtATimeQueryOr " + str3;
			result +="\n";
			System.out.println(a.size() + " documents are found");
			result +=a.size() + " documents are found";
			result +="\n";
			System.out.println("No comparisons are made");
			result +="No comparisons are made";
			result +="\n";
			long estimatedTime1 = System.currentTimeMillis() - startTime1;
			System.out.println((estimatedTime1 / 1000.0) + " seconds are used");
			result +=(estimatedTime1 / 1000.0) + " seconds are used";
			result +="\n";
			Collections.sort(a);
			System.out.print("Result: ");
			result +="Result: ";
			for (Integer o : a) {
				System.out.print(o + ", ");
				result +=o + ", ";
			}
		} else {
			Integer[] pointer = new Integer[splited33.size()];
			for (int i = 0; i < pointer.length; i++) {
				pointer[i] = 0;

			}
			Integer[] comparison = new Integer[splited33.size()];
			Integer[] mainfor = new Integer[splited33.size()];
			LinkedList<CSE535Assignment> temp;

			for (int v6 = 0; v6 < splited33.size(); v6++) {
				temp = hm.get(splited33.get(v6));
				mainfor[v6] = temp.size();

			}

			int max1 = mainfor[0];
			for (int v7 = 1; v7 < mainfor.length; v7++) {
				max1 = max1 * mainfor[v7];
			}
			int v8 = max1 + 100;
			// Integer.MAX_VALUE

			for (int v3 = 0; v3 < v8; v3++) {
				for (int j = 0; j < splited33.size(); j++)//
				{
					temp = hm.get(splited33.get(j));// all the words
					if (pointer[j] < temp.size()) {
						comparison[j] = temp.get(pointer[j]).docId;
					} else {
						comparison[j] = Integer.MAX_VALUE;

					}

				}

				int min = comparison[0];
				int v1 = 1;
				int v12 = 0;

				for (int v11 = 0; v11 < comparison.length; v11++) {
					int s1 = Integer.MAX_VALUE;
					if (comparison[v11] == s1) {
						v12 = v12 + 1;
						if (v12 == comparison.length) {
							System.out.print("FUNCTION: DocumentAtATimeQueryOr ");
							result +="FUNCTION: DocumentAtATimeQueryOr ";
							for (int p6 = 0; p6 < splited33.size() - 1; p6++) {
								System.out.print(splited33.get(p6) + ", ");
								result +=splited33.get(p6) + ", ";
							}
							System.out.print(splited33.get(splited33.size() - 1));
							result +=splited33.get(splited33.size() - 1);
							System.out.print("\n");
							result +="\n";
							System.out.println(finallist.size()+ " documents are found");
							result +=finallist.size()+ " documents are found";
							result +="\n";
							System.out.println(total + " comparisons are made");
							result +=total + " comparisons are made";
							result +="\n";
							long estimatedTime = System.currentTimeMillis()- startTime1;
							System.out.println((estimatedTime / 1000.0)+ " seconds are used");
							result +=(estimatedTime / 1000.0)+ " seconds are used";
							result +="\n";
							Collections.sort(finallist);
							System.out.print("Result: ");
							result +="Result: ";
							for (Integer o : finallist) {
								System.out.print(o + ", ");
								result += o + ", ";
							}
							return result;
						}
					}
					
				}

				for (int q = 1; q < comparison.length; q++) {
					int s = comparison[0];
					total = total + 1;
					if (comparison[q] == s) {
						v1 = v1 + 1;
						if (v1 == comparison.length) {
							finallist.add(comparison[q]);
							for (int v2 = 0; v2 < comparison.length; v2++) {
								pointer[v2] = pointer[v2] + 1;
							}
						}
					}

				}

				if (v1 < comparison.length) {
					for (int w = 1; w < comparison.length; w++) {
						if (comparison[w] < min) {
							min = comparison[w];
						}
					}
					finallist.add(min);

					for (int z = 0; z < comparison.length; z++) {
						total = total + 1;
						int v9 = min;
						if (comparison[z] == v9) {
							pointer[z] = pointer[z] + 1;
						}
					}
				}
			}

		}
		return result;
	}

	public static String docAtATimeQueryAnd(String k,
			HashMap<String, LinkedList<CSE535Assignment>> hm)
			throws IOException {
		String result="";
		// Map.Entry<String, LinkedList<CSE535Assignment>> e = (Entry<String,
		// LinkedList<CSE535Assignment>>) hm.entrySet();
		// Collections.sort(e, new Comparator<CSE535Assignment>(){
		// public int compare(CSE535Assignment a, CSE535Assignment b) {
		// if (b.docId < a.docId)
		// return 1;
		// else if (b.docId > a.docId)
		// return -1;
		// else
		// return 0;
		// }
		// });
		long startTime1 = System.currentTimeMillis();
		String str3 = k;
		int total = 0;
		LinkedList<Integer> finallist = new LinkedList<Integer>();
		String[] splited3 = str3.split("\\s+");
		ArrayList<String> splited33 = new ArrayList<String>();
		boolean present = true;
		for (String s : splited3) {
			present = hm.containsKey(s);
			if (present) {
				splited33.add(s);

			}

		}
		 if(splited33.size()==splited3.length)
		 {
		for (int i = 0; i < splited33.size(); i++) {
			for (Map.Entry<String, LinkedList<CSE535Assignment>> e : hm
					.entrySet()) {
				if (splited33.get(i).equals(e.getKey())) {

					Collections.sort(e.getValue(),
							new Comparator<CSE535Assignment>() {
								public int compare(CSE535Assignment a,
										CSE535Assignment b) {
									if (b.docId < a.docId)
										return 1;
									else if (b.docId > a.docId)
										return -1;
									else
										return 0;
								}
							});
				}
			}
		}
		HashMap<String, LinkedList<Integer>> daat = new HashMap<String, LinkedList<Integer>>();
		for (int p9 = 0; p9 < splited33.size(); p9++) {
			LinkedList<Integer> daatV = new LinkedList<Integer>();
			LinkedList<CSE535Assignment> p = hm.get(splited33.get(p9));
			for (CSE535Assignment l1 : p) {
				// System.out.println(l1.docId);
				daatV.add(l1.docId);

			}
			daat.put(splited33.get(p9), daatV);

		}

		LinkedList<Integer> a = daat.get(splited33.get(0));

		if (splited33.size() == 1) {
			System.out.println("FUNCTION: DocumentAtATimeQueryAnd " + str3);
			result +="FUNCTION: DocumentAtATimeQueryAnd " + str3;
			result +="\n";
			System.out.println(a.size() + " documents are found");
			result +=a.size() + " documents are found";
			result +="\n";
			System.out.println("No comparisons are made");
			result +="No comparisons are made";
			result +="\n";
			long estimatedTime1 = System.currentTimeMillis() - startTime1;
			System.out.println((estimatedTime1 / 1000.0) + " seconds are used");
			result +=(estimatedTime1 / 1000.0) + " seconds are used";
			result +="\n";
			Collections.sort(a);
			System.out.print("Result: ");
			result +="Result: ";
			for (Integer o : a) {
				System.out.print(o + ", ");
				result += o + ", ";
			}
		} else {

			if (splited33.size() == splited3.length) {
				int v5 = 0;
				Integer[] pointer = new Integer[splited33.size()];
				for (int i = 0; i < pointer.length; i++) {
					pointer[i] = 0;

				}
				Integer[] comparison = new Integer[splited33.size()];
				Integer[] mainfor = new Integer[splited33.size()];
				LinkedList<CSE535Assignment> temp;
				for (int v6 = 0; v6 < splited33.size(); v6++) {
					temp = hm.get(splited33.get(v6));
					mainfor[v6] = temp.size();

				}
				int max1 = mainfor[0];
				for (int v7 = 1; v7 < mainfor.length; v7++) {
					max1 = max1 * mainfor[v7];
				}
				int v8 = max1 + 100;
				// Integer.MAX_VALUE
				for (int v3 = 0; v3 < v8; v3++) {
					for (int j = 0; j < splited33.size(); j++)//
					{
						temp = hm.get(splited33.get(j));// all the words
						if (pointer[j] < temp.size()) {
							comparison[j] = temp.get(pointer[j]).docId;
						} else {
							v5 = 1;
							break;
						}

					}
					if (v5 != 1) {

						int max = comparison[0];
						int v1 = 1;
						for (int w = 1; w < comparison.length; w++) {
							if (comparison[w] > max) {
								max = comparison[w];
							}
						}
						for (int q = 1; q < comparison.length; q++) {
							int s = comparison[0];
							total = total + 1;
							if (comparison[q] == s) {
								v1 = v1 + 1;
								if (v1 == comparison.length) {
									finallist.add(comparison[q]);
									// System.out.println("yo"+comparison[q]);
									for (int v2 = 0; v2 < comparison.length; v2++) {
										pointer[v2] = pointer[v2] + 1;
									}
								}
							}
						}

						if (v1 < comparison.length) {
							for (int e = 0; e < comparison.length; e++) {
								total = total + 1;
								if (comparison[e] < max) {
									pointer[e] = pointer[e] + 1;
								}
							}

						}

					} else {
						break;
					}
				}
				System.out.print("FUNCTION: DocumentAtATimeQueryAnd ");
				result +="FUNCTION: DocumentAtATimeQueryAnd ";
				for (int p6 = 0; p6 < splited3.length - 1; p6++) {
					System.out.print(splited3[p6] + ", ");
					result +=splited3[p6] + ", ";
				}
				System.out.print(splited3[splited3.length - 1] + ", ");
				result +=splited3[splited3.length - 1] + ", ";
				System.out.print("\n");
				result +="\n";
				System.out.println(finallist.size() + " documents are found");
				result +=finallist.size() + " documents are found";
				result +="\n";
				System.out.println(total + " comparisons are made");
				result +=total + " comparisons are made";
				result +="\n";
				long estimatedTime = System.currentTimeMillis() - startTime1;
				System.out.println((estimatedTime / 1000.0)
						+ " seconds are used");
				result +=(estimatedTime / 1000.0)
				+ " seconds are used";
				result +="\n";
				Collections.sort(finallist);
				System.out.print("Result: ");
				result +="Result: ";
				for (Integer o : finallist) {
					System.out.print(o + ", ");
					result += o + ", ";
				}
			}
		}
		} else {
			System.out.print("FUNCTION: DocumentAtATimeQueryAnd ");
			result +="FUNCTION: DocumentAtATimeQueryAnd ";
			for (int p20 = 0; p20 < splited3.length; p20++) {
				System.out.print(splited3[p20] + ", ");
				result +=splited3[p20] + ", ";
			}
			System.out.print("\n");
			result +="\n";
			System.out.println("Result: Terms not found");
			result +="Result: Terms not found";
		}
		return result;

	}

	public static String termAtATimeQueryOr(String k,
			HashMap<String, LinkedList<CSE535Assignment>> hm)
			throws IOException {
		String result="";
		long startTime = System.currentTimeMillis();
		int v4 = 0;

		String str = k;
		String[] splited = str.split("\\s+");
		ArrayList<String> splited1 = new ArrayList<String>();
		boolean present = true;
		for (String s : splited) {
			present = hm.containsKey(s);
			if (present) {
				splited1.add(s);

			} else {
				result +="FUNCTION termAtATimeQueryOr: Term not found " + s;
				result +="\n";
				System.out.println("FUNCTION termAtATimeQueryOr: Term not found " + s);
				// System.out.println("\n");
			}
		}
		HashMap<String, LinkedList<Integer>> taat = new HashMap<String, LinkedList<Integer>>();
		for (int i = 0; i < splited1.size(); i++) {
			LinkedList<Integer> taatV = new LinkedList<Integer>();
			LinkedList<CSE535Assignment> p = hm.get(splited1.get(i));
			for (CSE535Assignment l1 : p) {
				// System.out.println(l1.docId);
				taatV.add(l1.docId);

			}
			taat.put(splited1.get(i), taatV);
		}

		LinkedList<Integer> a = taat.get(splited1.get(0));
		// if (a.size() !=0 || b.size() !=0) {

		if (splited1.size() == 1) {
			if (a.size() != 0) {
				result +="FUNCTION: termAtATimeQueryOr "
						+ splited1.get(0);
				System.out.print("FUNCTION: termAtATimeQueryOr "
						+ splited1.get(0));
				result +="\n";
				System.out.print("\n");
				result +=a.size() + " documents are found";
				result +="\n";
				System.out.println(a.size() + " documents are found");
				result +="No comparisons are made";
				result +="\n";
				System.out.println("No comparisons are made");
				long estimatedTime = System.currentTimeMillis() - startTime;
				System.out.println((estimatedTime / 1000.0)
						+ " seconds are used");
				result +=(estimatedTime / 1000.0)
						+ " seconds are used";
				result +="\n";
				Collections.sort(a);
				System.out.print("Result: ");
				result +="Result: ";
				for (Integer o : a) {
					System.out.print(o + ", ");
					result += o + ", ";
				}
			} else {
				System.out.println("No posting list for: " + splited1.get(0));
				result +="No posting list for: " + splited1.get(0);
			}

		} else {
			LinkedList<Integer> temp = new LinkedList<Integer>();
			for (int v5 = 0; v5 < a.size(); v5++) {
				temp.add(a.get(v5));
			}

			for (int j = 0; j < splited1.size() - 1; j++)// go across words
			{

				LinkedList<Integer> b = taat.get(splited1.get(j + 1));

				for (int p = 0; p < b.size(); p++) {
					int v6 = 0;
					for (int q = 0; q < temp.size(); q++) {
						int v1 = temp.get(q);
						int v2 = b.get(p);
						v4 = 1 + v4;
						if (v1 != v2) {
							v6 = v6 + 1;
						}
					}
					if (v6 == temp.size()) {
						temp.add(b.get(p));
					}
				}
				// a.clear();
				// for(int v3=0;v3<temp.size();v3++){
				// a.add(temp.get(v3));
				// }
				// temp.clear();

			}
			result +="FUNCTION: termAtATimeQueryOr ";
			System.out.print("FUNCTION: termAtATimeQueryOr ");
			for (int p6 = 0; p6 < splited1.size(); p6++) {
				System.out.print(splited1.get(p6) + ", ");
				result +=splited1.get(p6) + ", ";
			}

			System.out.print("\n");
			result +="\n";
			System.out.println(temp.size() + " documents are found");
			
			result +=temp.size() + " documents are found";
			result +="\n";
			System.out.println(v4 + " comparisons are made");
			result +=v4 + " comparisons are made";
			result +="\n";
			long estimatedTime = System.currentTimeMillis() - startTime;
			System.out.print((estimatedTime / 1000.0) + " seconds are used");
			result +=(estimatedTime / 1000.0) + " seconds are used";
			result +="\n";
			Collections.sort(temp);
			System.out.print("Result: ");
			result +="Result: ";
			for (Integer o : temp) {
				System.out.print(o + ", ");
				result +=o + ", ";
			}
		}
		return result;

	}

	// TAAT AND QUERY

	public static String termAtATimeQueryAnd(String k,
			HashMap<String, LinkedList<CSE535Assignment>> hm)
			throws IOException {
		String result="";
		long startTime = System.currentTimeMillis();
		int v4 = 0;
		String str = k;
		String[] splited = str.split("\\s+");
		ArrayList<String> splited1 = new ArrayList<String>();
		boolean present = true;
		for (String s : splited) {
			present = hm.containsKey(s);
			if (present) {
				splited1.add(s);

			}

		}

		if (splited1.size() == splited.length) {
			HashMap<String, LinkedList<Integer>> taat = new HashMap<String, LinkedList<Integer>>();
			for (int i = 0; i < splited1.size(); i++) {
				LinkedList<Integer> taatV = new LinkedList<Integer>();
				LinkedList<CSE535Assignment> p = hm.get(splited1.get(i));
				for (CSE535Assignment l1 : p) {
					// System.out.println(l1.docId);
					taatV.add(l1.docId);

				}
				taat.put(splited1.get(i), taatV);
			}

			LinkedList<Integer> a = taat.get(splited1.get(0));
			if (splited1.size() == 1) {
				if (a.size() != 0) {
					result +="FUNCTION: termAtATimeQueryAnd " + str;
					System.out.println("FUNCTION: termAtATimeQueryAnd " + str);
					result +="\n";
					System.out.println();
					result +=a.size() + " documents are found";
					result +="\n";
					System.out.println(a.size() + " documents are found");
					result +="No comparisons are made";
					
					System.out.println("No comparisons are made");
					long estimatedTime = System.currentTimeMillis() - startTime;
					result +=(estimatedTime / 1000.0)+ " seconds are used";
					result +="\n";
					System.out.println((estimatedTime / 1000.0)+ " seconds are used");
					Collections.sort(a);
					System.out.print("Result: ");
					for (Integer o : a) {
						result +=o + ", ";
						System.out.print(o + ", ");
					}
				} else {
					result +="No posting list for: "
							+ splited1.get(0);
					System.out.println("No posting list for: "
							+ splited1.get(0));
				}

			} else {

				LinkedList<Integer> temp = new LinkedList<Integer>();
				for (int j = 0; j < splited1.size() - 1; j++)// go across words
				{

					LinkedList<Integer> b = taat.get(splited1.get(j + 1));

					for (int p = 0; p < a.size(); p++) {
						for (int q = 0; q < b.size(); q++) {
							int v1 = a.get(p);
							int v2 = b.get(q);
							v4 = 1 + v4;
							if (v1 == v2) {
								temp.add(v2);
							}
						}
					}
					a.clear();
					for (int v3 = 0; v3 < temp.size(); v3++) {
						a.add(temp.get(v3));
					}
					temp.clear();

				}
				result +="FUNCTION: termAtATimeQueryAnd ";
				System.out.print("FUNCTION: termAtATimeQueryAnd ");
				for (int p5 = 0; p5 < splited.length; p5++) {
					result +=splited[p5] + ", ";
					System.out.print(splited[p5] + ", ");
				}
				result +="\n";
				System.out.print("\n");
				result +=a.size() + " documents are found";
				result +="\n";
				System.out.println(a.size() + " documents are found");
				
				result +=v4 + " comparisons are made";
				System.out.println(v4 + " comparisons are made");
				result +="\n";
				long estimatedTime = System.currentTimeMillis() - startTime;
				System.out.print((estimatedTime / 1000.0) + " seconds are used");
				result +=(estimatedTime / 1000.0) + " seconds are used";
				result +="\n";
				Collections.sort(a);
				result +="Result: ";
				System.out.print("Result: ");
				for (Integer o : a) {
					result +=o + ", ";
					System.out.print(o + ", ");
				}
			}

		} else {
			result +="FUNCTION: termAtATimeQueryAnd ";
			System.out.print("FUNCTION: termAtATimeQueryAnd ");
			for (int p20 = 0; p20 < splited.length; p20++) {
				result +=splited[p20] + ", ";
				System.out.print(splited[p20] + ", ");
			}
			result +="\n";
			System.out.print("\n");
			result +="Result: Terms not found";
			
			System.out.print("Result: Terms not found");

		}
		return result;

	}

	// second query

	public static String getPostings(String k,HashMap<String, LinkedList<CSE535Assignment>> postinghm)
			throws IOException {
		String result = "";
		String str4 = k;
		String[] splited4 = str4.split("\\s+");
		ArrayList<String> splited44 = new ArrayList<String>();
		/*
		 * HashMap<String, LinkedList<CSE535Assignment>> postinghm = new
		 * HashMap<String, LinkedList<CSE535Assignment>>(hm);
		 */
		// postinghm.putAll(hm);;
		boolean present = true;
		for (String s : splited4) {
			present = postinghm.containsKey(s);
			if (present) {
				splited44.add(s);
			} else {
				result +="FUNCTION: getPostings: Term not found " + s;
				System.out.println("FUNCTION: getPostings: Term not found " + s);
				
			}
		}

		for (int i = 0; i < splited44.size(); i++) {
			for (Map.Entry<String, LinkedList<CSE535Assignment>> e : postinghm
					.entrySet()) {
				if (splited44.get(i).equals(e.getKey())) {
					String key = e.getKey();
					result+="\n";
					result +="FUNCTION: getPostings " + key;
					result +="\n";
					System.out.println("FUNCTION: getPostings " + key);
					Collections.sort(e.getValue(),
							new Comparator<CSE535Assignment>() {
								public int compare(CSE535Assignment a,
										CSE535Assignment b) {
									if (b.docId < a.docId)
										return 1;
									else if (b.docId > a.docId)
										return -1;
									else
										return 0;
								}
							});
					result +="Ordered by doc IDs: ";
					System.out.print("Ordered by doc IDs: ");
					for (CSE535Assignment l2 : e.getValue()) {
						result +=l2.docId + ", ";
						System.out.print(l2.docId + ", ");
					}
					//printList(e.getValue());
					// System.out.println("Checkpoint");
					result +="\n";
					System.out.print("\n");
					Collections.sort(e.getValue(), Collections.reverseOrder());
					result +="Ordered by TF: ";
					System.out.print("Ordered by TF: ");
					// printList(e.getValue());
					for (CSE535Assignment l1 : e.getValue()) {
						result +=l1.docId + ", ";
						System.out.print(l1.docId + ", ");
					}
					
					System.out.print("\n");
				}
				// Collections.sort(e.getValue(), new
				// Comparator<CSE535Assignment>(){
				// public int compare(CSE535Assignment a, CSE535Assignment b) {
				// if (b.docId < a.docId)
				// return 1;
				// else if (b.docId > a.docId)
				// return -1;
				// else
				// return 0;
				// }
				// });
			}
		}
		return result;
	}

	public static String printList(LinkedList<CSE535Assignment> e) {
		String result = "";
		for (CSE535Assignment l1 : e) {
			result +=l1.docId + ", ";
			System.out.print(l1.docId + ", ");
		}
		return result;

	}

	public static String getTopk(int k) throws NumberFormatException,
			IOException {
		String result = "";
		File InputFile = new File(kterms);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(InputFile)));
		String line = null;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while ((line = br.readLine()) != null) {
			// for (String retval: line.split("\\\\",3)){
			String[] retval = line.split("\\\\", 3);
			String a = retval[0];
			// System.out.println(a);
			int b = Integer.parseInt(retval[1].substring(1));
			hm.put(a, b);
		}
		Set<Entry<String, Integer>> entrySet = hm.entrySet();
		List<Entry<String, Integer>> listOfentrySet = new ArrayList<Entry<String, Integer>>(
				entrySet);

		result += "FUNCTION: getTopK: " + k;
		System.out.println("FUNCTION: getTopK: " + k);

		Collections.sort(listOfentrySet, new SortByValue());
		int count = 0;
		Iterator i = listOfentrySet.iterator();
		// Display elements
		result += "\nResult: ";
		System.out.print("Result: ");

		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();

			result += me.getKey() + ", ";

			System.out.print(me.getKey() + ", ");

			count = count + 1;
			if (count == k)
				break;
		}
		// for(Map.Entry<String, Integer> entry:listOfentrySet)
		// System.out.print(entry.getKey());
		System.out.println();
		return result;
	}

}
