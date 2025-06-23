// Importing the Scanner class to take user input from the console
import java.util.Scanner;

// Class to check whether a given number is a palindrome
public class palindrone {

    /**
     * This method takes an integer 'n' and returns its reverse.
     * For example: if n = 123, it returns 321.
     * 
     * @param n the number to reverse
     * @return the reversed number
     */
    public static int rev(int n) {
        int rev = 0;  // Variable to store the reversed number

        // Loop to reverse the digits of the number
        while (n > 0) {
            int rem = n % 10;           // Extract the last digit
            rev = rev * 10 + rem;       // Append it to the reversed number
            n = n / 10;                 // Remove the last digit from 'n'
        }

        return rev;  // Return the final reversed number
    }

    /**
     * This method checks whether the given number is a palindrome.
     * A number is a palindrome if it reads the same forwards and backwards.
     * 
     * @param n the number to check
     * @return true if 'n' is a palindrome, false otherwise
     */
    public static Boolean pali(int n) {
        return (rev(n) == n);  // Compare the number with its reverse
    }

    /**
     * Main method: Entry point of the program.
     * Reads input from the user, checks if it's a palindrome, and prints the result.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Create a Scanner object for user input
        int n = sc.nextInt();                  // Read an integer from the user

        // Output true if the number is a palindrome, false otherwise
        System.out.println(pali(n));

        sc.close();
    }
}
