import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
 
//sort self-defined object linkedlist in Java
 
class House implements Comparable<House> {
	String type;
	int size;
 
	public House(String t, int s) {
		type = t; 
		size = s;
	}
 
	public int compareTo(House o) {
		int comparedSize = o.size;
		if (this.size > comparedSize) {
			return 1;
		} else if (this.size == comparedSize) {
			return 0;
		} else {
			return -1;
		}
	}
 
	public String toString() {
		return type;
	}
}
 
public class SortLinkedList {
	public static void main(String[] args) {
		LinkedList<House> houseList = new LinkedList<House>();
		houseList.add(new House("medium", 200));
		houseList.add(new House("small", 100));
		houseList.add(new House("large", 300));
		System.out.println(houseList);
 
	// sort in ascending order
//		Collections.sort(houseList);
//		System.out.println(houseList);
 
		// sort in descending order
		Collections.sort(houseList, Collections.reverseOrder());
		System.out.println(houseList);
	}
 
	public static void printList(List l) {
		for (Object o : l) {
			System.out.println(o);
		}
	}
}