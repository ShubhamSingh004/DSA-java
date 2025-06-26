public class BubbleSort {

    /**
     * Function: bubbleSort
     * --------------------
     * Sorts the given array in ascending order using the Bubble Sort algorithm.
     * Repeatedly compares adjacent elements and swaps them if they are in the wrong
     * order.
     *
     * Time Complexity:
     * - Worst Case: O(n²) → when the array is in reverse order
     * - Best Case: O(n²) → this version does not have an early exit flag
     * (Can be improved to O(n) with a swapped flag for best case) -> which is done
     *
     * Space Complexity: O(1) — in-place sort
     * Stable: Yes — preserves relative order of equal elements
     *
     * @param arr the input array of integers
     * @return the sorted array in ascending order
     */
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop controls number of passes
        for (int i = 0; i < n; i++) {
            boolean didSwap = false;
            // Inner loop performs pairwise comparisons and swaps
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if elements are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    didSwap = true;
                }
            }

            if (!didSwap)
                break;
        }

        return arr;
    }

    /**
     * Function: bubbleSortRecursive
     * -----------------------------
     * Recursively sorts the given array in ascending order using Bubble Sort.
     * Bubble Sort works by repeatedly moving the largest unsorted element to the
     * end of the array in each pass.
     *
     * This is a recursive version of Bubble Sort. On each recursive call:
     * - It performs one full pass over the first 'n' elements
     * - Bubbles the largest among them to the last position
     * - Then it recursively sorts the remaining (n - 1) elements
     *
     * Time Complexity:
     * - Worst Case: O(n²)
     * - n recursive calls
     * - each call does up to (n-1) comparisons/swaps
     * - Best Case: O(n²) (no early stopping on sorted array in this implementation)
     *
     * Space Complexity:
     * - O(n) due to recursion stack (not in-place from call-stack perspective)
     *
     * Stability:
     * - Stable sorting algorithm (does not change relative order of equal elements)
     *
     * Interview Note:
     * - Shows understanding of recursion and in-place sorting
     * - Not used in real-world code; preferred for academic or conceptual purposes
     *
     * @param arr The array to be sorted
     * @param n   The effective length of the sub-array to be sorted in current call
     */
    static void bubbleSortRecursive(int[] arr, int n) {
        // Base case: when size reduces to 1, array is already sorted
        if (n == 1)
            return;

        // Perform one pass through the array to push the maximum element to end
        for (int j = 0; j < n - 1; j++) {
            // Swap if elements are in the wrong order
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        // Recursively sort the remaining unsorted portion (n - 1 elements)
        bubbleSortRecursive(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] input = { 9, 8, 7, 61, 2, 0 };

        System.out.println("Sorted Array:");
        for (int ele : bubbleSort(input)) {
            System.out.println(ele);
        }

        int[] input2 = { 9, 8, 100, 61, 2, -1 };

        bubbleSortRecursive(input2, input2.length);
        for (int ele : input2) {
            System.out.println(ele);
        }
    }
}