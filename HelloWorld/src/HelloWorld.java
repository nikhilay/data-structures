import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HelloWorld {

	public static void main(String[] args) throws IOException {
		String str= "dfdfj dhfhef dffhjhfjhf dfhd  dfhjdfhd";
		String[] splited = str.split("\\s+");
//		String first = splited[0];
//		String[] trailing = Arrays.copyOfRange(splited,1,splited.length);
		String j="dfdfj";
		for (int i=0;i<splited.length;i++){
			if (splited[i].equalsIgnoreCase(j))
					System.out.println("true"+splited[i]);
			System.out.println(splited[i]);
		}
	}
}
