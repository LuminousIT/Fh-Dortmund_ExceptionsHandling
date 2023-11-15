import java.util.Scanner;

class HandlingMultipleExceptions {
    public static void main(String[] args) {
        // Create a tool to get input from the user
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask the user for the price of the book
            System.out.print("Enter  book price:€");
            double bookPrice = scanner.nextDouble();

            // Ask the user for the number of books they want to buy
            System.out.print("Enter  quantity: ");
            int quantity = scanner.nextInt();

            // Calculate the total cost of the books
            double totalPrice = calculateTotalPrice(bookPrice, quantity);

            // Show the user the total cost
            System.out.println("Total Price: $" + totalPrice);

            // Simulate the payment process
            processPayment(totalPrice);

        } catch (java.util.InputMismatchException e) {
            // Handle the situation where the user enters something that's not a number
            System.out.println("ERROR: Kindly enter valid numeric values.");

        } catch (IllegalArgumentException e) {
            // Handle the situation wh0ere there's something wrong with the values entered
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Close the tool used to get input from the user
            scanner.close();
            // Say thank you to the user
            System.out.println("Vielen Dank!");
        }
    }

    // Calculate the total cost of the books
    private static double calculateTotalPrice(double bookPrice, int quantity) {
        // Check if the entered values for book price and quantity make sense
        if (bookPrice <= 0 || quantity <= 0) {
            // If not, tell the user there's a problem
            throw new IllegalArgumentException("Book price and quantity must be greater than zero.");
        }

        // If everything is fine, calculate and return the total cost
        return bookPrice * quantity;
    }

    // Simulate the process of paying for the books
    private static void processPayment(double totalPrice) {
        // If the total cost is greater than zero, consider the payment successful
        if (totalPrice > 0) {
            System.out.println("Thank you for your purchase!");
        } else {
            // If the total cost is not valid, tell the user there's a problem
            throw new IllegalArgumentException("Invalid total price. Please check your order.");
        }
    }
}
