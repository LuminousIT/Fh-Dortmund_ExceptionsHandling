// Java program to illustrate
// Automatic Resource Management

import java.io.*;
import java.util.*;

public class ResourceManagement2 {

	public static void main(String args[]) {
		String str = "";
		BufferedReader br = null;

		System.out.println("Enter the file path");
		br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// try with Resource
		// note the syntax difference
		try (BufferedReader b = new BufferedReader(new FileReader(str))) {
			String s;
			while ((s = b.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/**
 * In the try-with-resources method, there is no use of the finally block. 
 * The file resource is opened in try block inside small brackets. 
 * Only the objects of those classes can be opened within the block which implements the 
 * AutoCloseable interface, and those objects should also be local. 
 * The resource will be closed automatically regardless of whether the try statement 
 * completes normally or abruptly. 

 * Syntax: 
 * The following example reads the first line from a file. 
 * It uses an instance of BufferedReader to read data from the file. 
 * BufferedReader is a resource that must be closed after the program is finished with it: 
 * **/
