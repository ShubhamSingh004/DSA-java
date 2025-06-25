// Define a public class named 'Factorial'
public class Factorial {

    // Recursive method to compute factorial of a number 'n'
    static int fact(int n) {
        // Base case: factorial of 0 is defined as 1
        if(n == 0)
            return 1;

        // Recursive case: n! = n * (n-1)!
        return n * fact(n - 1);
    }

    // Main method - entry point of the program
    public static void main(String[] args)
    {
        // Call the 'fact' method with argument 5 and print the result
        // Output should be: Factorial: 120
        System.out.println("Factorial: " + fact(5));
    }
}