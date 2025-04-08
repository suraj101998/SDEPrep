package CodingInterview;
/*
 * remove duplicate characters from a string while maintaining the original order
 */
import java.util.*;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                result.append(currentChar);
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String input = "programming";
        String output = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("After Removing Duplicates: " + output);
    }
}

/*
Time & Space Complexity:
Time Complexity: O(N) — Iterates through the string once.
Space Complexity: O(N) — Uses a HashSet and StringBuilder for storage.
 */

