// package basicMath;
import java.util.Scanner;

public class countNumbers {
    public static void main(String[] args) {
        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();  // Read an integer from the user

        // Convert the number to its absolute value to handle negative input
        int nabs = Math.abs(n);

        // Method 1: Iterative approach using division
        // int res = count1(nabs);

        // Method 2: Logarithmic approach using Math.log10
        int res = countLog(nabs);

        // Display the digit count
        System.out.println("Count: " + res);

        // Close the Scanner to free resources
        sc.close();
    }

    // Method to count number of digits using iterative division
    public static int count1(int n) {
        if (n == 0) {
            return 1;  // Special case: 0 has 1 digit
        }

        int count = 0;

        // Divide the number by 10 until it becomes 0
        while (n > 0) {
            count++;       // Increment digit count
            n = n / 10;    // Remove the last digit
        }
        return count;      // Return total number of digits
    }

    // Method to count number of digits using logarithmic approach
    public static int countLog(int n) {
        if (n == 0) {
            return 1;  // Special case: log10(0) is undefined, so manually return 1
        }

        // log10(n) gives number of digits - 1
        // Adding 1 gives the exact digit count
        return (int) Math.log10(n) + 1;
    }
}
