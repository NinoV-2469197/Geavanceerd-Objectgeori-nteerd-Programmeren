/*
Write a program that generates 25 random int values. For each
value, use an if-else statement to classify it as greater than, less
than or equal to a second randomly-generated value.
 */
import java.util.Random;

public class RandomNumberClassifier {
    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate the first random integer
        int previousValue = random.nextInt(101); // Generates a random integer from 0 to 100
        System.out.println("Initial value: " + previousValue); // Display the initial value

        for (int i = 1; i < 25; i++) {
            // Generate the next random integer
            int currentValue = random.nextInt(101); // Generates a random integer from 0 to 100

            // Use if-else statements to classify the current value relative to the previous value
            String classification;
            if (previousValue > currentValue) {
                classification = "greater than";
            } else if (previousValue < currentValue) {
                classification = "less than";
            } else {
                classification = "equal to";
            }

            // Print the result
            System.out.printf("Value %d is %s Value %d.%n", previousValue, classification, currentValue);

            // Update previousValue to the currentValue for the next comparison
            previousValue = currentValue;
        }
    }
}
