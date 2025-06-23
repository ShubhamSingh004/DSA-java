// This class provides functionality to reverse a given integer number.
// The main logic is implemented in the reverseNumber1 method.
public class reverseNumber {

    /**
     * This method takes an integer 'n' as input and returns its reverse.
     * For example: if n = 1234, the output will be 4321.
     * 
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public static int reverseNumber1(int n) {
        int rev = 0;  // Variable to store the reversed number

        // Iterate until the number becomes 0
        while (n > 0) {
            int rem = n % 10; // Extract the last digit of 'n' (remainder)
            rev = rev * 10 + rem; // Append the extracted digit to 'rev'
            n = n / 10; // Remove the last digit from 'n'
        }

        return rev; // Return the final reversed number
    }

    /**
     * The main method serves as the entry point of the program.
     * It initializes a number, calls the reverse function, and prints the result.
     */
    public static void main(String[] args) {
        int n = 123456; // Input number to reverse

        // Call the reverseNumber1 method to reverse the number
        int res = reverseNumber1(n);

        // Output the result
        System.out.println("Reversed: " + res);
    }
}
