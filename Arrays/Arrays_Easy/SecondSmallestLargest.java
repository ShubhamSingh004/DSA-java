public class SecondSmallestLargest {

    /**
     * ✅ Method 1: Two-pass approach
     * --------------------------------
     * First pass: Find the largest and smallest elements.
     * Second pass: Find the second largest and second smallest elements by comparing
     *              with the largest and smallest found in the first pass.
     *
     * ➤ Time Complexity: O(n) + O(n) = O(n)
     * ➤ Space Complexity: O(1) — Uses constant extra space.
     *
     * ➤ Handles edge cases: duplicate elements, uniform arrays, negatives, etc.
     */
    static void find2ndLargestSmallest(int[] arr) {

        // Defensive check for arrays with less than 2 elements
        if (arr.length == 0 || arr.length == 1) {
            System.out.println("Array must contain at least 2 elements");
            return;
        }

        // Initialize largest and smallest to extreme values
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;

        // Initialize second largest and second smallest to extremes
        int secondLargest = Integer.MIN_VALUE, secondSmallest = Integer.MAX_VALUE;

        // First pass: Find largest and smallest elements
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
            smallest = Math.min(smallest, arr[i]);
        }

        // Second pass: Find second largest and second smallest elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < largest && arr[i] > secondLargest)
                secondLargest = arr[i];

            if (arr[i] > smallest && arr[i] < secondSmallest)
                secondSmallest = arr[i];
        }

        // Print largest and smallest
        System.out.println("Largest: " + largest + " | Smallest: " + smallest);

        // Validate and print second largest
        if (secondLargest == Integer.MIN_VALUE)
            System.out.println("Second largest doesn't exist (all elements may be the same or only one unique max)");
        else
            System.out.println("Second Largest: " + secondLargest);

        // Validate and print second smallest
        if (secondSmallest == Integer.MAX_VALUE)
            System.out.println("Second smallest doesn't exist (all elements may be the same or only one unique min)");
        else
            System.out.println("Second Smallest: " + secondSmallest);
    }


    /**
     * ✅ Method 2: Optimized single-pass approach
     * ------------------------------------------
     * Find second largest and second smallest in a single traversal of the array.
     *
     * ➤ Time Complexity: O(n) — Only one loop.
     * ➤ Space Complexity: O(1) — Uses only a few variables.
     *
     * ➤ More efficient than the two-pass version but requires careful edge case handling.
     */
    static void find2ndLargestSmallest2(int[] arr){

        // Defensive check for arrays with less than 2 elements
        if(arr.length < 2){
            System.out.println("Array must have at least 2 elements");
            return;
        }

        // Initialize smallest and second smallest
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // Initialize largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Single pass: update largest/smallest and their second counterparts
        for(int i = 0; i < arr.length; i++){
            // Update largest and second largest
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] < largest){
                secondLargest = arr[i];
            }

            // Update smallest and second smallest
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] < secondSmallest && arr[i] > smallest){
                secondSmallest = arr[i];
            }
        }

        // Handle case where all elements are same or no second distinct value exists
        if(secondLargest == Integer.MIN_VALUE || secondSmallest == Integer.MAX_VALUE){
            System.out.println("The array has all same elements or no valid second smallest/largest");
            return;
        }

        // Print the results
        System.out.println("Second Largest: " + secondLargest + " | Second Smallest: " + secondSmallest);
    }


    // Main method to test both approaches with two arrays
    public static void main(String[] args) {
        int[] input1 = new int[] { 1, 2, 3, 4, 5, 100, 80, -1 };
        int[] input2 = new int[] { 1, 1, 1, 1 };

        // Call the two-pass version
        find2ndLargestSmallest(input1);
        System.out.println();
        find2ndLargestSmallest(input2);

        System.out.println("\nOptimized");

        // Call the single-pass optimized version
        find2ndLargestSmallest2(input1);
        System.out.println();
        find2ndLargestSmallest2(input2);
    }
}