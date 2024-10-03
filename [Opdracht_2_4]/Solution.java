public class Solution {
    public static void main(String[] args) {
        // Define an object reference and initialize it to null
        String str = null;

        try {
            // Attempt to call a method on the null reference
            int length = str.length();
        } catch (NullPointerException e) {
            // Catch the NullPointerException and handle it
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }
    }
}
