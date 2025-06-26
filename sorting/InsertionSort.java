public class InsertionSort {

    /**
     * Function: insertionSort
     * -----------------------
     * Sorts the array in ascending order using the Insertion Sort algorithm.
     * In each iteration, it inserts the current element into its correct position
     * within the sorted portion of the array (left side).
     *
     * Time Complexity:
     * - Worst Case: O(n²) — when array is reverse sorted
     * - Best Case: O(n) — when array is already sorted
     * - Average Case: O(n²)
     *
     * Space Complexity: O(1) — in-place sorting
     * Stable: Yes — preserves the order of equal elements
     *
     * @param arr The input array to sort
     * @return The sorted array
     */
    static int[] insertionSort(int[] arr) {
        // Start from the second element (index 1)
        for (int i = 1; i < arr.length; i++) {

            int j = i;

            // Shift elements to the right until the correct position for arr[i] is found
            while (j > 0 && arr[j] < arr[j - 1]) {
                // Swap arr[j] with its previous element
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--; // Move one step to the left
            }
        }

        // Return the sorted array
        return arr;
    }

    /**
     * Function: insertionSortRecursive
     * --------------------------------
     * Recursively sorts the array using the Insertion Sort algorithm.
     *
     * Insertion Sort works by maintaining a sorted subarray on the left,
     * and inserting each new element into its correct position.
     *
     * In this recursive version:
     * - Each recursive call handles inserting one element into its correct
     * position.
     * - Starts from index 1 (typically), and continues until the end of the array.
     *
     * Time Complexity:
     * - Worst Case: O(n²) → e.g., array in descending order
     * - Best Case: O(n) → array already sorted (but this version doesn't break
     * early)
     *
     * Space Complexity:
     * - O(n) → due to recursion stack (one frame per call)
     *
     * Stability:
     * - Yes (insertion sort is a stable sorting algorithm)
     *
     * Interview Use:
     * - Good for demonstrating recursion and algorithmic thinking
     * - Not used in production due to recursion overhead
     *
     * @param arr   The array to be sorted
     * @param start The current index being inserted into sorted portion
     */
    static void insertionSortRecursive(int[] arr, int start) {
        // Base case: if all elements are processed, return
        if (start == arr.length)
            return;

        // Insert arr[start] into its correct position in the sorted portion
        // [0...start-1]
        int j = start;
        while (j > 0 && arr[j - 1] > arr[j]) {
            // Swap with the previous element until the correct position is found
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        // Recursively sort the remaining elements
        insertionSortRecursive(arr, start + 1);
    }

    public static void main(String[] args) {
        // Input array and function call to perform insertion sort
        for (int ele : insertionSort(new int[] { 9, 0, 7, 3, 9, 8, 0 })) {
            System.out.println(ele); // Output each sorted element
        }

        int[] input = new int[] { -1, 8, 9, 0, 3, 100, 0 };
        insertionSortRecursive(input, 0);

        System.out.println("Insertion Sort recursive");
        for (int ele : input) {
            System.out.println(ele); // Output each sorted element
        }
    }
}
