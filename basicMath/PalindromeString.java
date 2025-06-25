public class PalindromeString {

    /**
     * Iterative method to check if a given string is a palindrome.
     * This method compares characters from both ends moving inward.
     * 
     * Time Complexity: O(n) → each character is checked once.
     * Space Complexity: O(1) → uses constant space (just two pointers).
     */
    static Boolean paliBoolean(String str) {
        int i = 0;                    // Left pointer
        int j = str.length() - 1;     // Right pointer

        while (i < j) {
            // If characters at current pointers don't match, it's not a palindrome
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Move both pointers inward
            i++;
            j--;
        }

        // All corresponding characters matched; it's a palindrome
        return true;
    }

    /**
     * Recursive method with two pointers to check if a string is a palindrome.
     * This approach recursively compares characters at the start and end of the string.
     * 
     * Time Complexity: O(n) → each character is checked once.
     * Space Complexity: O(n) → due to recursion stack (function call per character pair).
     */
    static Boolean isPaiRecursive(String str, int start, int end) {

        // Base case: if start index crosses or meets end, it's a palindrome
        if (start >= end)
            return true;

        // If mismatch found, it's not a palindrome
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursively check the inner substring
        return isPaiRecursive(str, start + 1, end - 1);
    }

    /**
     * Recursive method with a single pointer to check if a string is a palindrome.
     * Compares the character at position `i` with its symmetric counterpart.
     * 
     * Time Complexity: O(n) → one comparison per character pair.
     * Space Complexity: O(n) → due to recursion stack.
     */
    static Boolean isPaiRecursive(String str, int i) {
        // Base case: if we reach or cross the middle, it's a palindrome
        if (i >= str.length() / 2)
            return true;

        // If characters at mirrored positions do not match
        if (str.charAt(i) != str.charAt(str.length() - 1 - i))
            return false;

        // Move the pointer forward and continue checking
        return isPaiRecursive(str, i + 1);
    }

    public static void main(String[] args) {
        // Testing iterative approach
        // System.out.println("Is Palindrome: " + paliBoolean("Car"));   // false
        // System.out.println("Is Palindrome: " + paliBoolean("Mom"));   // false (case-sensitive)
        // System.out.println("Is Palindrome: " + paliBoolean("MOM"));   // true

        // Testing recursive approach with 2 pointers
        // System.out.println("Is Palindrome: " + isPaiRecursive("Car", 0, 2));   // false
        // System.out.println("Is Palindrome: " + isPaiRecursive("Mom", 0, 2));   // false
        // System.out.println("Is Palindrome: " + isPaiRecursive("MOM", 0, 2));   // true

        // Testing recursive approach with 1 pointer
        System.out.println("Is Palindrome: " + isPaiRecursive("Car", 0));   // false
        System.out.println("Is Palindrome: " + isPaiRecursive("Mom", 0));   // false
        System.out.println("Is Palindrome: " + isPaiRecursive("MOM", 0));   // true
    }
}