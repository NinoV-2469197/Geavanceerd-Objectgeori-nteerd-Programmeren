/* Write a program that prints three arguments taken from the
command line. To do this, you’ll need to index into the command-
line array of Strings. */

public class CommandLineArgs {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide exactly three arguments.");
            return;
        }

        // Accessing the arguments from the command line
        String arg1 = args[0];
        String arg2 = args[1];
        String arg3 = args[2];

        // Printing the arguments
        System.out.println("Argument 1: " + arg1);
        System.out.println("Argument 2: " + arg2);
        System.out.println("Argument 3: " + arg3);
    }
}