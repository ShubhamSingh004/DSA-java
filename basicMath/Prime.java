public class Prime {

    // Method to check whether a number is prime
    static Boolean isPrime(int n) {

        // Prime numbers are greater than 1
        if (n == 0 || n == 1) {
            return false; // 0 and 1 are not prime numbers
        }

        // Loop from 2 to square root of 'n'
        // If 'n' is divisible by any number in this range, it is not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {

            // If 'n' is divisible by 'i', then it has a factor other than 1 and itself
            if (n % i == 0)
                return false; // Hence, not prime
        }

        // If no divisors found, then 'n' is a prime number
        return true;
    }

    // Main method - entry point of the program
    public static void main(String[] args) {

        int n = 1483; // Sample input number to check for primality

        // Print the result of the isPrime method
        System.out.println(isPrime(n)); // Output will be true if prime, false otherwise
    }
}