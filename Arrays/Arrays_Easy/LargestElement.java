public class LargestElement {

    // Iterative method to find the index of the largest element in the array
    static int findLargestIndex(int[] arr) {
        // Assume the first element is the largest initially
        int largestIndex = 0;

        // Traverse the array from start to end
        for (int i = 0; i < arr.length; i++) {
            // If current element is greater than the element at largestIndex, update largestIndex
            if (arr[i] > arr[largestIndex]) {
                largestIndex = i;
            }
        }

        // Return the index of the largest element
        return largestIndex;
    }

    /*
     * Recursive method to find the index of the largest element in the array.
     * Parameters:
     * - arr: the input array
     * - start: current index being inspected
     * - largestIndex: current index of the largest value found so far
     */
    static int findLargestIndexRecursive(int[] arr, int start, int largestIndex) {
        // Base case: if start reaches end of array, return the largest index found
        if (start == arr.length) return largestIndex;

        // If current element is greater than element at largestIndex, update largestIndex
        if (arr[start] > arr[largestIndex])
            largestIndex = start;

        // Recursive call to check next index
        return findLargestIndexRecursive(arr, start + 1, largestIndex);
    }

    public static void main(String[] args) {
        // Sample input array
        int[] arr = new int[] {100, 0, 9, 1001, -1};

        // Defensive check to handle empty array case
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return; // Exit the program early
        }

        // Call iterative method and print the largest element value using its index
        System.out.println("Largest Element is: " + arr[findLargestIndex(arr)]);

        // Call recursive method and print the largest element value using its index
        System.out.println("Recursive: " + arr[findLargestIndexRecursive(arr, 0, 0)]);
    }
}