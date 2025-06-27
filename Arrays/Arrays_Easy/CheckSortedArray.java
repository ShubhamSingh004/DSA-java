public class CheckSortedArray {

    /**
     * Checks if the given integer array is sorted in non-decreasing (ascending) order.
     *
     * Logic:
     * - Traverses the array from index 0 to n - 2
     * - Compares each element with the next one (arr[i] and arr[i + 1])
     * - If any element is greater than the next, the array is unsorted, and the function returns false
     * - If the loop completes without finding such a pair, the array is sorted
     *
     * Edge Cases:
     * - Empty array (length == 0) → Returns true (trivially sorted)
     * - Single element array → Returns true (trivially sorted)
     *
     * Time Complexity: O(n)
     * - Where n is the number of elements in the array
     * - We traverse the array once to perform n - 1 comparisons
     *
     * Space Complexity: O(1)
     * - No additional space is used; only loop variables are required
     *
     * @param arr the array to check
     * @return true if the array is sorted in non-decreasing order, false otherwise
     */
    static boolean checkSorted(int[] arr) {
        // Traverse the array up to the second last element
        for (int i = 0; i < arr.length - 1; i++) {
            // If the current element is greater than the next one, array is not sorted
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        // If the loop completes, array is sorted
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 5, 6, 10 };      // sorted
        int[] input2 = new int[] { 1, 2, 3, 15, 6, 10 };    // not sorted

        System.out.println(checkSorted(input));            // Output: true
        System.out.println(checkSorted(input2));           // Output: false
        System.out.println(checkSorted(new int[] {}));     // Output: true (empty = sorted)
        System.out.println(checkSorted(new int[] { 1 }));  // Output: true
    }
}