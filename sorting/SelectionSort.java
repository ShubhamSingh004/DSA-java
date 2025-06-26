public class SelectionSort {

    /**
     * Function: selectionSort
     * -----------------------
     * Sorts the given array using the **Selection Sort** algorithm.
     *
     * Selection Sort works by repeatedly finding the minimum element from the
     * unsorted portion and placing it at the beginning.
     *
     * Time Complexity:
     *   - Worst Case: O(n²)
     *   - Average Case: O(n²)
     *   - Best Case: O(n²) (even if already sorted, it still makes all comparisons)
     *
     * Space Complexity:
     *   - O(1) (in-place sorting, no extra space used)
     *
     * Stability:
     *   - Not a stable sort (unless modified)
     *
     * Interview Note:
     *   - Good for educational purposes.
     *   - Not used in production due to quadratic time.
     *
     * @param arr The input array to be sorted
     * @return The sorted array in ascending order
     */
    static int[] selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through the entire array
        for (int i = 0; i < n; i++) {
            // Assume the current index has the smallest element
            int lowestIndex = i;

            // Find the actual smallest element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[lowestIndex]) {
                    lowestIndex = j;
                }
            }

            // Swap the smallest element found with the element at index i
            int temp = arr[lowestIndex];
            arr[lowestIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;  // Return the sorted array
    }

    public static void main(String[] args) {
        System.out.println("Sorted Array");

        // Call selectionSort and print each element
        for (int ele : selectionSort(new int[] { 10, 9, 8, 6, 4, 11, 7 })) {
            System.out.print(ele + " ");
        }
    }
}