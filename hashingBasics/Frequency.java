import java.util.HashMap;

public class Frequency {

    /**
     * Brute Force Method using Visited Array (Fixed Range)
     * ----------------------------------------------------
     * Finds the element with the highest and lowest frequency in the input array.
     * 
     * @param arr the input array containing integers (values must be in range [0, 99])
     * @return an int array of format: [lowestFreq, elementWithLowestFreq, highestFreq, elementWithHighestFreq]
     *
     * Time Complexity:
     *   - Outer loop: O(n)
     *   - Inner loop (nested): O(n)
     *   - Total: O(n^2)
     * 
     * Space Complexity:
     *   - O(1) extra space (excluding the result array) because the `visited[]` array is of fixed size 100
     *   - Not suitable for arrays with values > 99 or negative integers
     */
    static int[] highestLowestFreq(int[] arr){
        int highest = 0;
        int lowest = arr.length;

        int hVal = 0, lVal = 0;

        boolean[] visited = new boolean[100]; // Fixed size range for visited tracking

        for(int i = 0; i < arr.length; i++){
            if(visited[arr[i]]) // Skip if already counted
                continue;

            int count = 0;
            for(int j = i; j < arr.length; j++){ // Count frequency of arr[i]
                if(arr[j] == arr[i]){
                    count++;
                }
            }

            visited[arr[i]] = true; // Mark as visited

            if(count > highest){
                highest = count;
                hVal = arr[i];
            }

            if(count < lowest){
                lowest = count;
                lVal = arr[i];
            }
        }

        return new int[]{lowest, lVal, highest, hVal};
    }


    /**
     * Optimized Method Using HashMap (Handles all integer ranges)
     * ------------------------------------------------------------
     * Builds a frequency map of the array and identifies the elements
     * with the highest and lowest frequency.
     * 
     * @param arr the input integer array
     *
     * Time Complexity:
     *   - O(n): where n is the length of the array
     *     - First pass to build the frequency map: O(n)
     *     - Second pass through map entries: O(n) in worst-case (unique elements)
     * 
     * Space Complexity:
     *   - O(n): extra space used by HashMap to store frequencies
     *     - In worst-case, all elements are unique → O(n) map size
     */
    static void highestLowestFreqHashMap(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Build frequency map
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int maxFreq = 0, minFreq = arr.length;
        int maxEle = 0, minEle = 0;

        // Step 2: Traverse through the frequency map to find required values
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

        // Output the result
        System.out.println("\nHash Map");
        System.out.println("The lowest frequency element is: " + minEle + " with count: " + minFreq);
        System.out.println("The highest frequency element is: " + maxEle + " with count: " + maxFreq);
    }


    public static void main(String[] args)
    {
        int[] arr = highestLowestFreq(new int[]{1, 1, 4, 5, 5, 5});

        System.out.println("Brute Force");
        System.out.println("Lowest freq value and count: " + arr[1] + " " + arr[0]);
        System.out.println("Highest freq value and count: " + arr[3] + " " + arr[2]);

        highestLowestFreqHashMap(new int[]{1, 1, 4, 5, 5, 5});
    }
}
