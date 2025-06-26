import java.util.HashMap;

public class CharCount {

    /**
     * Function: countEachChar
     * ------------------------
     * Counts the frequency of each ASCII character in the given string.
     *
     * Time Complexity: O(n)
     *      - where n is the length of the input string
     * Space Complexity: O(1)
     *      - uses a fixed-size array of length 256 (constant space, independent of input size)
     *
     * Note (Interview Context):
     * - Use this approach if the character set is strictly limited to ASCII (e.g., in competitive programming).
     * - Not preferred in job interviews unless performance is the main concern and constraints are clear.
     */
    static int[] countEachChar(String str) {
        int hash[] = new int[256];  // Covers all extended ASCII characters (0–255)

        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)] += 1;  // Increment frequency at ASCII index
        }

        return hash;
    }

    /**
     * Function: countCharHashMap
     * ---------------------------
     * Counts the frequency of each character using a HashMap.
     *
     * Time Complexity: O(n)
     *      - where n is the length of the input string
     * Space Complexity: O(k)
     *      - where k is the number of unique characters in the input string
     *
     * ✅ Interview Best Practice:
     * - Preferred in interviews because:
     *      • Works for any character set (Unicode, emojis, multilingual).
     *      • Demonstrates understanding of Java Collections.
     *      • Code is more readable and maintainable.
     * - Should be your default approach unless ASCII-only optimization is explicitly required.
     */
    static HashMap<Character, Integer> countCharHashMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Use get + put for clarity, but computeIfPresent/compute() can be used in advanced cases
            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        // Sample case-sensitive input string
        String str = "AAbbAacC";

        System.out.println(str);

        // Approach 1: Using ASCII-based fixed-size array
        // Use only for ASCII inputs (e.g., a-z, A-Z); O(1) space
        int[] count = countEachChar(str);

        // Query individual character frequencies
        char ch = 'b';
        System.out.println(ch + " occurs " + count[ch] + " times");

        char ch2 = 'o';
        System.out.println(ch2 + " occurs " + count[ch2] + " times");

        // Approach 2: Using HashMap (Best for interviews)
        System.out.println("\nHash Map");
        HashMap<Character, Integer> map = countCharHashMap(str);

        // Iterating over key-value pairs using keySet
        for (Character key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        // Tip: In interviews, you can also use entrySet or Java 8 forEach for clean iteration.
    }
}
