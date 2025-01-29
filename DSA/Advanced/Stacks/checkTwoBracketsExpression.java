package DSA.Advanced.Stacks;

import java.util.Stack;

/*
 * Problem Description
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.



Problem Constraints
1 <= length of the each String <= 100



Input Format
The given arguments are string A and string B.



Output Format
Return 1 if they represent the same expression else return 0.



Example Input
Input 1:

 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:

 A = "a-b-(c-d)"
 B = "a-b-c-d"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 
Explanation 2:

 Both the expression are different.
 */
public class checkTwoBracketsExpression {
    
    int MAX_CHAR = 26;

    public int solve(String A, String B) {
        if (areSame(A, B))
            return 1;
        return 0;
    }

    Boolean areSame(String expr1, String expr2) {
        int v[] = new int[MAX_CHAR];
        eval(expr1, v, true);
        // calls the second expression with opposite sign
        eval(expr2, v, false);
        // checks if both the expressions are equal
        for (int i = 0; i < MAX_CHAR; i++)
            if (v[i] != 0)
                return false;
        return true;
    }

    void eval(String s, int v[], Boolean add) {
        Stack < Boolean > stk = new Stack < Boolean > ();
        stk.push(true);
        int i = 0;
        // we evaluate the contribution of each character in the expression
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                i++;
                continue;
            }
            if (c == '(') {
                if (adjSign(s, i))
                    stk.push(stk.peek());
                else
                    stk.push(!stk.peek());
            } else if (c == ')')
                stk.pop();
            else {
                if (stk.peek())
                    v[c - 'a'] += (adjSign(s, i) ? add ? 1 : -1 :
                        add ? -1 : 1);
                else
                    v[c - 'a'] += (adjSign(s, i) ? add ? -1 : 1 :
                        add ? 1 : -1);
            }
            i++;
        }
    }
    
    Boolean adjSign(String s, int i) {
        if (i == 0)
            return true;
        if (s.charAt(i - 1) == '-')
            return false;
        return true;
    };
}
