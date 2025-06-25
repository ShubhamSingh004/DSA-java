// Class demonstrating three methods to reverse an array in Java
public class ReverseArray {

    // Utility method to print array elements in a single line
    static void printArray(int arr[]) {
        for (int ele : arr)
            System.out.print(ele + " "); // Print each element followed by a space
        System.out.println(); // Move to the next line after printing
    }

    // -----------------------------
    // Method 1: Reverse using a new array
    // Time Complexity: O(n)
    // Space Complexity: O(n) - extra array used
    // -----------------------------
    static int[] reverseArr1(int arr[]) {
        int res[] = new int[arr.length]; // Create a new array to store reversed values

        for (int i = 0; i < arr.length; i++) {
            // Fill the new array from the end with elements from the original array
            res[arr.length - 1 - i] = arr[i];
        }

        return res; // Return the new reversed array
    }

    // -----------------------------
    // Method 2: In-place reverse using arithmetic swap
    // Time Complexity: O(n)
    // Space Complexity: O(1) - no extra space used
    // Note: This can cause integer overflow for large values
    // -----------------------------
    static int[] reverseArr2(int[] arr) {
        int left = 0; // Start index
        int right = arr.length - 1; // End index

        while (left < right) {
            // Swap elements at left and right without using a temp variable
            arr[left] = arr[left] + arr[right]; // Step 1: sum
            arr[right] = arr[left] - arr[right]; // Step 2: extract original arr[left]
            arr[left] = arr[left] - arr[right]; // Step 3: extract original arr[right]

            left++;
            right--;
        }

        return arr; // Return the same array after in-place reversal
    }

    // -----------------------------
    // Method 3: In-place reverse using recursion
    // Time Complexity: O(n)
    // Space Complexity: O(n) - due to recursion call stack
    // -----------------------------
    static int[] reverseArrRecursive(int[] arr, int start, int end) {
        // Base condition: when start index meets or crosses end index, stop recursion
        if (start < end) {
            // Swap the elements at start and end
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            // Recursive call for the next inner pair
            return reverseArrRecursive(arr, start + 1, end - 1);
        }

        return arr; // Return the reversed array once all swaps are done
    }

    // -----------------------------
    // Main method: entry point of the program
    // -----------------------------
    public static void main(String[] args) {
        // Method 1: Using extra array (non-destructive)
        // printArray(reverseArr1(new int[]{1, 2, 3, 4, 5}));

        // Method 2: In-place arithmetic swap (destructive)
        // printArray(reverseArr2(new int[]{1, 2, 3, 4, 5}));

        // Method 3: In-place recursive reversal (destructive)
        printArray(reverseArrRecursive(new int[]{1, 2, 3, 4, 5}, 0, 5 - 1));
    }
}
