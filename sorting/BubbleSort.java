public class BubbleSort {

    /**
     * Function: bubbleSort
     * --------------------
     * Sorts the given array in ascending order using the Bubble Sort algorithm.
     * Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     *
     * Time Complexity:
     *   - Worst Case: O(n²) → when the array is in reverse order
     *   - Best Case: O(n²) → this version does not have an early exit flag
     *   (Can be improved to O(n) with a swapped flag for best case) -> which is done
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

            if(!didSwap)
                break;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] input = {9, 8, 7, 61, 2, 0};

        System.out.println("Sorted Array:");
        for (int ele : bubbleSort(input)) {
            System.out.println(ele);
        }
    }
}