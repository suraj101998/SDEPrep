package CodingInterview;
/*
 Mintfi

 Remove the Duplicate words from the given String. 
 Input: I am good at Java at good Hyderabad.
 Output: I am Java Hydreabad.
 */
import java.util.*;

public class removeDuplicateWords {
    public static String removeDuplicateWord(String input) {
        String[] words = input.split("\\s+"); // Split by spaces
        Set<String> seen = new LinkedHashSet<>();

        for (String word : words) {
            seen.add(word);
        }

        return String.join(" ", seen);
    }

    public static void main(String[] args) {
        String input = "I am good at Java at good Hyderabad.";
        String output = removeDuplicateWord(input);
        System.out.println("Original String: " + input);
        System.out.println("After Removing Duplicate Words: " + output);
    }
}
