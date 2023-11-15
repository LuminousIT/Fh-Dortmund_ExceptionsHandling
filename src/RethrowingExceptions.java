import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RethrowingExceptions {

    public static void main(String[] args) {
        try {
            handleExceptions();
        } catch (CustomProblem e) {
            System.out.println("Caught CustomProblem: " + e.getMessage());
            System.out.println("Original issue: " + e.getCause().getMessage());
        }
    }

    // Re-throwing Exceptions
    public static void handleExceptions() throws CustomProblem {
        try {
            riskyOperation();
        } catch (IOException e) {
            System.out.println("Issue caught: " + e.getMessage());
            throw new CustomProblem("Custom problem message", e);
        }
    }

    // A method that throws an IOException
    private static void riskyOperation() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("nonexistent-file.txt"));
        fileReader.readLine();
    }
}

// CustomProblem class that extends Exception
class CustomProblem extends Exception {
    public CustomProblem(String message, Throwable cause) {
        super(message, cause);
    }
}

