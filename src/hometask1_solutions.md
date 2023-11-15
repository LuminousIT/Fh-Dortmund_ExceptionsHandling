### Example of the try-with-resources statement

The try-with-resources is a try statement that declares one or more resources and ensures each resource is closed at the end of the statement.

```java
import java.io.*;

class Main {
  public static void main(String[] args) {
    String line;
    try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
      while ((line = br.readLine()) != null) {
        System.out.println("Line =>"+line);
      }
    } catch (IOException e) {
      System.out.println("IOException in try block =>" + e.getMessage());
    }
  }
}
```

### Purpose of throw statement
The throw statement is used to break out of the normal flow of a program when there's an error. The throw statement throws an object that can be handled in the catch or finally block.

### Which classes inherit from Throwable class
All errors and exceptions class in the Java language inherit from the throwable class. Eg **Error** class **Exception** class

### Examples of catching and handling exceptions
```java
public class Example1 {
	public static void main(String args[]){
		 try {
			int[] myNumbers = {1, 2, 3};
			System.out.println(myNumbers[5]);
	     } catch (Exception e) {
	       System.out.println("Something went wrong.");
	     }
	}
}
```

```java
public class Example2 {
	public static void main(String args[]){
		 try {
			int[] myNumbers = {1, 2, 3};
			System.out.println(myNumbers[5]);
	   	} catch (Exception e) {
	       System.out.println("Something went wrong.");
	    	} finally {
      		System.out.println("The 'try catch' is finished.");
    		}
	}
}
```

```java
// demonstrate throw
public class Example3 {
  public static void checkAge(int age) {
    if (age < 18) {
    throw new ArithmeticException("Access denied - You must be at least 18 		years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    checkAge(15); 
  }
}
```

```java
// demonstrate throw and handles results
public class Example4 {
  public static void checkAge(int age) {
    if (age < 18) {
    throw new ArithmeticException("Access denied - You must be at least 18 		years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
  	try {
  	 checkAge(15); 
  	} catch(ArithmeticException exception) {
  		System.out.println("Error", exception.message);
  	}
   
  }
}
```

```java
public void writeList() {
    PrintWriter out = null;

    try {
        System.out.println("Entering" + " try statement");

        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    } catch (IndexOutOfBoundsException e) {
        System.err.println("Caught IndexOutOfBoundsException: "
                           +  e.getMessage());

    } catch (IOException e) {
        System.err.println("Caught IOException: " +  e.getMessage());

    } finally {
        if (out != null) {
            System.out.println("Closing PrintWriter");
            out.close();
        }
        else {
            System.out.println("PrintWriter not open");
        }
    }
}
```