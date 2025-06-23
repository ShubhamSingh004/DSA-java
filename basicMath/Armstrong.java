public class Armstrong {

    // Method to count the number of digits using logarithmic approach
    public static int countLog(int n) {
        if (n == 0) {
            return 1;  // log10(0) is undefined; return 1 manually for input 0
        }

        // log10(n) returns number of digits - 1; add 1 to get the actual digit count
        return (int) Math.log10(n) + 1;
    }

    // Method to check whether a number is an Armstrong number
    static Boolean armstrong1(int n) {
        // Count number of digits using String conversion (can also use countLog(n))
        int len = String.valueOf(n).length();

        int sum = 0;          // Variable to store the sum of powered digits
        int n_temp = n;       // Store the original number for final comparison

        // Iterate through each digit of the number
        while (n > 0) {
            int rem = n % 10;                      // Extract the last digit
            sum += (int) Math.pow(rem, len);       // Raise digit to the power 'len' and add to sum
            n = n / 10;                            // Remove the last digit
        }

        // Check if the sum of powered digits equals the original number
        return n_temp == sum;
    }

    // Main method: entry point of the program
    public static void main(String[] args) {
        int n = 1634;  // Input number to be checked

        // Call method with absolute value to avoid negative number issues
        System.out.println("Armstrong: " + armstrong1(Math.abs(n)));
    }
}
