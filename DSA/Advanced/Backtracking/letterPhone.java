package DSA.Advanced.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Description
Given a digit string A, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
NOTE: Make sure the returned strings are lexicographically sorted.

Problem Constraints
1 <= |A| <= 10

Input Format
The only argument is a digit string A.

Output Format
Return a string array denoting the possible letter combinations.

Example Input
Input 1:
 A = "23"
Input 2:
 A = "012"

Example Output
Output 1:
 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:
 ["01a", "01b", "01c"]

Example Explanation
Explanation 1:
 There are 9 possible letter combinations.
Explanation 2:
 Only 3 possible letter combinations.
 */
public class letterPhone {
    private static final String[] MAPPING = {
        "0", "1", "abc", "def", "ghi", "jkl", 
        "mno", "pqrs", "tuv", "wxyz"
    };
    public static String[] letterCombinations(String A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length() == 0) return result.toArray(new String[0]);
        backtrack(0, A, new StringBuilder(), result);
        return result.toArray(new String[0]);
    }
    private static void backtrack(int index, String A, StringBuilder current, List<String> result) {
        if (index == A.length()) {
            result.add(current.toString());
            return;
        }
        String letters = MAPPING[A.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(index + 1, A, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public static void main(String[] args){
        String A = "23";
        String[] result  = letterCombinations(A);
        System.out.println("ans: "+Arrays.toString(result));
    }
}
