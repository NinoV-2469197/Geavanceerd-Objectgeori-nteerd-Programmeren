/*
Create a class with two methods, f( ) and g( ). In g( ), throw an
exception of a new type that you define. In f( ), call g( ), catch its
exception and, in the catch clause, throw a different exception (of
a second type that you define). Test your code in main( ).
 */
// Define the first custom exception class
public class FirstCustomException extends Exception {
    public FirstCustomException(String message) {
        super(message);
    }
}
