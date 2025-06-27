public class RemoveDuplicate { // Remove duplicates from a sorted array

    /**
     * Removes duplicates from a sorted array in-place.
     * 
     * The method modifies the input array so that the first k+1 elements are unique,
     * and returns the position of the last unique element.
     * 
     * Assumptions:
     * - The input array is sorted in non-decreasing order.
     * - All duplicates are adjacent due to sorting.
     *
     * Approach:
     * - Use two pointers: i (tracks index of last unique element),
     *   and j (scans through the array).
     * - If arr[j] != arr[i], then arr[j] is a new unique element.
     *   Increment i and copy arr[j] to arr[i].
     * 
     * Time Complexity: O(n)
     * - Each element is visited once in a single pass.
     * 
     * Space Complexity: O(1)
     * - In-place operation; no extra space used apart from a few variables.
     * 
     * @param arr Sorted input array
     * @return The index of the last unique element in the updated array
     */

     // can use HashSet also - but space complexity = O(N)
     
    static int removeDuplicate(int[] arr) {
        // Edge case: empty array
        if (arr.length == 0) return -1;

        int i = 0; // i tracks index of the last unique element

        // Traverse from second element onwards
        for (int j = 1; j < arr.length; j++) {
            // If a new unique element is found
            if (arr[i] != arr[j]) {
                arr[++i] = arr[j]; // Place it next to last unique
            }
        }

        return i + 1; // Return the position of last unique element
    }

    public static void main(String[] args) {
        int[] input1 = new int[] { 1, 1, 3, 4, 4, 7, 10 };

        int k = removeDuplicate(input1); // Function modifies array in-place

        // Print unique elements from index 0 to k
        for (int i = 0; i < k; i++) {
            System.out.println(input1[i]);
        }
    }
}
