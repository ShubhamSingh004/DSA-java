public class gcd {

    // Method 1: Brute Force Approach (Forward Loop)
    // Time Complexity: O(min(n1, n2))
    // Checks every number from 1 to min(n1, n2) and finds the highest number that divides both
    static int gcdOf1(int n1, int n2) {
        int gcd_res = 1;

        // Loop from 1 to the smaller of n1 and n2
        for (int i = 1; i < Math.min(n1, n2); i++) {
            // If i divides both numbers, update gcd_res
            if (n1 % i == 0 && n2 % i == 0)
                gcd_res = i;
        }

        return gcd_res;
    }

    // Method 2: Brute Force Approach (Reverse Loop - Early Exit)
    // Time Complexity: O(min(n1, n2)) but better in practice due to early return
    // Loops backward from min(n1, n2) and returns the first common divisor
    static int gcdOf2(int n1, int n2) {
        // Start from the smaller of the two numbers
        for (int i = Math.min(n2, n1); i > 0; i--) {
            // Return immediately once the highest common divisor is found
            if (n1 % i == 0 && n2 % i == 0)
                return i;
        }

        return 1; // If no common divisor found (only possible when one is 0)
    }

    // Method 3: Euclidean Algorithm (Efficient)
    // Time Complexity: O(log(min(n1, n2)))
    // Based on the principle that gcd(a, b) = gcd(b, a % b)
    static int gcdEuclidean(int a, int b) {
        // Iteratively apply the modulo operation until one number becomes 0
        while(a != 0 && b != 0){
            if(a > b)
                a = a % b; // Replace larger number with remainder
            else
                b = b % a;
        }

        // When one becomes 0, the other contains the GCD
        return (a == 0) ? b : a;
    }

    // Driver code
    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 20;

        // Uncomment to test each method
        // System.out.println("GCD (Method 1 - Forward Loop): " + gcdOf1(n1, n2));
        // System.out.println("GCD (Method 2 - Reverse Loop): " + gcdOf2(n1, n2));
        System.out.println("GCD (Euclidean Algorithm): " + gcdEuclidean(n1, n2));
    }
}
