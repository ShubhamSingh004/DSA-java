import java.util.ArrayList;

public class Divisors {

    // Function to compute all divisors of a given number n
    static ArrayList<Integer> getDivisors(int n) {
        // Initialize a dynamic array to store the divisors
        ArrayList<Integer> lst = new ArrayList<>();

        // Iterate from 1 to the square root of n
        // Because divisors always appear in pairs: (i, n/i)
        // You only need to check up to sqrt(n) to find all pairs
        for (int i = 1; i <= Math.sqrt(n); i++) {

            // If i divides n with no remainder, it's a valid divisor
            if (n % i == 0) {

                // Add the current divisor i
                lst.add(i);

                // Add the corresponding pair divisor n/i
                // Only add if it's different from i to avoid duplicates (important for perfect squares)
                if (i != n / i) {
                    lst.add(n / i);
                }
            }
        }

        // Return the list of all divisors found
        return lst;
    }

    public static void main(String[] args) {
        // Define the number whose divisors need to be found
        int n = 10;

        // Call the getDivisors function and print each element from the returned list
        for (int ele : getDivisors(n)) {
            System.out.println(ele);  // Output each divisor on a new line
        }
    }
}
