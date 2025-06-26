import java.util.HashMap;
import java.util.Map;

public class CountArray {

    /**
     * Naive Frequency Count Using Visited Array
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(n) for visited[]
     *
     *  Not recommended in interviews unless you're constrained to avoid hashing.
     * ✅ Educational for understanding brute-force iteration.
     */
    public static void countFreq(int arr[], int n) {
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + " : " + count);
        }
    }

    /**
     * Efficient Frequency Count Using HashMap
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k), where k = number of unique elements
     *
     * ✅ Preferred in interviews
     * ✅ Handles large, non-contiguous, or negative integer values easily
     * ✅ Shows understanding of Java collections and hashing
     */
    static HashMap<Integer, Integer> countArrEle(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            if (map.containsKey(ele)) {
                map.put(ele, map.get(ele) + 1);
            } else {
                map.put(ele, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 1, 3 };

        System.out.println("Output using Naive O(n²) approach:");
        countFreq(input, input.length);

        System.out.println("\n Output using HashMap O(n) approach:");
        HashMap<Integer, Integer> map = countArrEle(input);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}