/*
Create your own exception class using the extends keyword.
Write a constructor for this class that takes a String argument
and stores it inside the object with a String reference. Write a
method that prints out the stored String. Create a try-catch
clause to exercise your new exception.
 */
// Define the custom exception class
class MyCustomException extends Exception {
    // Constructor that takes a String argument
    public MyCustomException(String message) {
        super(message);
    }

    // Override the getMessage method
    @Override
    public String getMessage() {
        return "Custom Message: " + super.getMessage();
    }
}

// Test the custom exception class
public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            // Some condition to throw the custom exception
            throw new MyCustomException("This is a custom exception message.");
        } catch (MyCustomException e) {
            // Catch the custom exception and print the message using getMessage
            System.out.println("Caught MyCustomException");
            System.out.println(e.getMessage());
        }
    }
}
