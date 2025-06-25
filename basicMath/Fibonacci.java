public class Fibonacci {

    /**
     * Prints the first 'n' Fibonacci numbers iteratively.
     * Starts from F(0) = 0 and F(1) = 1, and continues up to F(n-1).
     *
     * Example: fib(5) → 0 1 1 2 3
     *
     * Time Complexity: O(n)
     *   - The loop runs (n - 2) times after printing the first two values.
     *
     * Space Complexity: O(1)
     *   - Uses constant space (only a few integer variables).
     */
    static void fib(int n) {

        if (n <= 0)
            return; // Invalid case: no numbers to print

        int i0 = 0;  // F(0)
        int i1 = 1;  // F(1)
        int res;     // Variable to store the current Fibonacci number

        // If only 1 Fibonacci number requested, print F(0)
        if (n == 1) {
            System.out.println(i0);
            return;
        }

        // Print first two Fibonacci numbers
        System.out.print(i0 + " " + i1 + " ");

        // Loop from index 2 to n - 1 (remaining n - 2 numbers)
        for (int i = 2; i < n; i++) {
            res = i0 + i1;       // Compute the next number
            System.out.print(res + " ");

            // Update previous two numbers for next iteration
            i0 = i1;
            i1 = res;
        }
    }

    /**
     * Recursively computes the nth Fibonacci number.
     *
     * Note: Indexing starts from F(0) = 0, F(1) = 1.
     *
     * Example: fibRecursive(4) → 3
     *
     * Time Complexity: O(2^n)
     *   - Each call branches into two recursive calls, forming a binary tree.
     *   - Exponential time due to overlapping subproblems.
     *
     * Space Complexity: O(n)
     *   - Maximum depth of recursion stack is 'n'.
     */
    static int fibRecursive(int n) {
        if (n <= 0)
            return 0; // Base case: F(0)

        if (n == 1)
            return 1; // Base case: F(1)

        // Recursive relation: F(n) = F(n-1) + F(n-2)
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        // Print first 10 Fibonacci numbers (from F(0) to F(9))
        fib(10);

        // Print the 10th Fibonacci number → F(9)
        // (Because fib(n) prints up to F(n-1))
        System.out.println("\n" + fibRecursive(10 - 1));
    }
}