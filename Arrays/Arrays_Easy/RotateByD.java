public class RotateByD {

    // Utility method to print the array elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static void printArray(int[] arr){
        for (int ele : arr)
            System.out.println(ele);
    }

    /**
     * Left rotate the array by 'd' positions using a temporary array.
     * Each element is shifted to the left by 'd' positions.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - due to the temporary array
     */
    static void leftRotateByD(int[] arr, int d) {
        if (arr.length == 0)
            return;

        d = d % arr.length;
        if (d == 0)
            return;

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[(i + d) % arr.length];
        }

        printArray(temp);
    }

    /**
     * Right rotate the array by 'd' positions using a temporary array.
     * Each element is moved 'd' positions ahead (circularly).
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - due to the temporary array
     */
    static void rightRotateByD(int[] arr, int d) {
        if (arr.length == 0)
            return;

        d = d % arr.length;
        if (d == 0)
            return;

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + d) % arr.length] = arr[i];
        }

        printArray(temp);
    }

    /**
     * Reverses a subarray from index 'start' to 'end' (inclusive).
     * Used internally for optimal rotation using reversal algorithm.
     * 
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1) - in-place reversal
     */
    static void reverseArray(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Right rotate the array by 'd' positions using the reversal algorithm.
     * Steps:
     * 1. Reverse the last 'd' elements.
     * 2. Reverse the first 'n - d' elements.
     * 3. Reverse the entire array.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - in-place rotation
     */
    static void rightRotateByDOpt(int[] arr, int d) {
        if (arr.length == 0)
            return;

        d = d % arr.length;
        if (d == 0)
            return;

        reverseArray(arr, arr.length - d, arr.length - 1);
        reverseArray(arr, 0, arr.length - d - 1);
        reverseArray(arr, 0, arr.length - 1);

        printArray(arr);
    }

    /**
     * Left rotate the array by 'd' positions using the reversal algorithm.
     * Steps:
     * 1. Reverse the first 'd' elements.
     * 2. Reverse the remaining 'n - d' elements.
     * 3. Reverse the entire array.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - in-place rotation
     */
    static void leftRotateByDOpt(int[] arr, int d) {
        if (arr.length == 0)
            return;

        d = d % arr.length;
        if (d == 0)
            return;

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);

        printArray(arr);
    }

    public static void main(String[] args) {
        System.out.println("Left Rotate by 3");
        leftRotateByD(new int[] { 1, 2, 3, 4, 5 }, 3);

        System.out.println("Right Rotate by 3");
        rightRotateByD(new int[] { 1, 2, 3, 4, 5 }, 10);

        System.out.println("Left Rotate by 3 (opt)");
        leftRotateByDOpt(new int[] { 1, 2, 3, 4, 5 }, 3);

        System.out.println("Right Rotate by 3 (opt)");
        rightRotateByDOpt(new int[] { 1, 2, 3, 4, 5 }, 10);
    }
}
