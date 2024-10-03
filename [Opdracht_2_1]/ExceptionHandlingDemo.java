/*
Create a class with a main( ) that throws an object of class
Exception inside a try block. Give the constructor for
Exception a String argument. Catch the exception inside a
catch clause and print the String argument. Add a finally clause
and print a message to prove you were there.
 */
public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        try {
            // Throwing an Exception with a String argument
            throw new Exception("This is a custom exception message.");
        } catch (Exception e) {
            // Catching the exception and printing the message
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            // Finally block to prove its presence
            System.out.println("Finally block executed.");
        }
    }
}
