/*
  Write a program that uses two nested for loops and the modulus
  operator (%) to detect and print prime numbers (integral numbers
  that are not evenly divisible by any other numbers except for
  themselves and 1).
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        // Define the range to find prime numbers
        int lowerBound = 2; // Lower bound of the range
        int upperBound = 100; // Upper bound of the range

        // Loop through each number in the range
        for (int number = lowerBound; number <= upperBound; number++) {
            boolean isPrime = true;

            // Check if the number is prime
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false; // Number is divisible by i, hence not prime
                    break;
                }
            }

            // Print the number if it is prime
            if (isPrime && number > 1) {
                System.out.println(number + " is a prime number.");
            }
        }
    }
}