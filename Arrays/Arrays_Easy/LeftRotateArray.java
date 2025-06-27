public class LeftRotateArray {

    /**
     * Brute-force approach to perform a left rotation of the array by one position.
     * 
     * Time Complexity: O(n)
     * - We iterate over the array once, performing O(1) operations per element.
     * 
     * Space Complexity: O(n)
     * - A new array of the same size is created to store the rotated result.
     * 
     * Logic:
     * - Copy each element from index 1 to the end into the previous index in the
     * result array.
     * - Place the first element of the original array at the last index of the
     * result array.
     */
    static int[] leftRotatte(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            res[i - 1] = arr[i]; // Shift each element one position to the left
        }

        res[arr.length - 1] = arr[0]; // Place the first element at the end

        return res;
    }

    /**
     * Optimal in-place approach to left rotate the array by one position.
     * 
     * Time Complexity: O(n)
     * - We iterate through the array once, moving each element leftward.
     * 
     * Space Complexity: O(1)
     * - No additional array is used; the original array is modified in-place.
     * 
     * Logic:
     * - Store the first element temporarily.
     * - Shift each of the remaining elements one position to the left.
     * - Place the initially stored first element at the end of the array.
     */
    static void leftRotateOptimal(int[] arr) {
        int first = arr[0]; // Store the first element

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i]; // Shift elements one step to the left
        }

        arr[arr.length - 1] = first; // Place the stored first element at the end
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };

        int[] res = leftRotatte(arr);

        System.out.println("First approach:");
        for (int ele : res)
            System.out.println(ele);

        System.out.println("Second Optimal (in place):");
        leftRotateOptimal(arr);
        for (int ele : arr)
            System.out.println(ele);
    }
}