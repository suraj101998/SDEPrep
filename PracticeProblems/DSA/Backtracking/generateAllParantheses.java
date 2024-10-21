package PracticeProblems.DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Description
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

Problem Constraints
1 <= A <= 10

Input Format
First and only argument is integer A.

Output Format
Return a sorted list of all possible parenthesis.

Example Input
Input 1:
A = 3
Input 2:
A = 1

Example Output
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:
[ "()" ]

Example Explanation
Explanation 1:
 All paranthesis are given in the output list.
Explanation 2:
 All paranthesis are given in the output list.
 */
public class generateAllParantheses {
    public String[] generateParenthesis(int A) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, "", 0, 0, A);
        return result.toArray(new String[0]);
    }
    private void generateCombinations(List<String> result, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }
        if (open < max) {
            generateCombinations(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateCombinations(result, current + ")", open, close + 1, max);
        }
    }
}
