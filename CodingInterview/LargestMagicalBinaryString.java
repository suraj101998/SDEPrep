package CodingInterview;

/*
 * A magical binary string follows these conditions:
It has equal numbers of 1s and 0s.
Every prefix has at least as many 1s as 0s.
Our goal is to form the largest lexicographically possible string by rearranging substrings.
 */

 /*
  * Algorithm
Divide the string into magical substrings:
Count 1s and 0s (1 should never be fewer than 0 at any prefix).
Whenever count becomes equal (1s == 0s), extract a magical substring.
Sort these substrings in descending order.
Recursively process each substring to maximize its value.
Reassemble the string by wrapping 1 around sorted substrings and appending 0.
  */
  import java.util.*;

  public class LargestMagicalBinaryString {
      public static String largestMagical(String binString) {
          if (binString.length() <= 1) return binString;
  
          List<String> magicalParts = new ArrayList<>();
          int count = 0, start = 0;
  
          // Step 1: Extract magical substrings
          for (int i = 0; i < binString.length(); i++) {
              count += (binString.charAt(i) == '1') ? 1 : -1;
              if (count == 0) {  // Found a balanced magical substring
                  String innerPart = "1" + largestMagical(binString.substring(start + 1, i)) + "0";
                  magicalParts.add(innerPart);
                  start = i + 1;
              }
          }
  
          // Step 2: Sort in descending order (largest lexicographically)
          magicalParts.sort(Comparator.reverseOrder());
  
          // Step 3: Reassemble the final string
          return String.join("", magicalParts);
      }
  
      public static void main(String[] args) {
          String binString = "11011000";
          System.out.println(largestMagical(binString));  // Output: "11100100"
      }
  }
  
/*
Time & Space Complexity

Extracting substrings: O(N)
Sorting substrings: O(N log N)
Recursion depth: O(N)
Final complexity: O(N log N).
This ensures an optimal solution for large N (≤10⁴).
*/