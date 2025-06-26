public class InsertionSort {

    /**
     * Function: insertionSort
     * -----------------------
     * Sorts the array in ascending order using the Insertion Sort algorithm.
     * In each iteration, it inserts the current element into its correct position
     * within the sorted portion of the array (left side).
     *
     * Time Complexity:
     *   - Worst Case: O(n²) — when array is reverse sorted
     *   - Best Case: O(n) — when array is already sorted
     *   - Average Case: O(n²)
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

                j--;  // Move one step to the left
            }
        }

        // Return the sorted array
        return arr;
    }

    public static void main(String[] args) {
        // Input array and function call to perform insertion sort
        for (int ele : insertionSort(new int[]{9, 0, 7, 3, 9, 8, 0})) {
            System.out.println(ele);  // Output each sorted element
        }
    }
}
