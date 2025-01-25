package DSA.Advanced.Stacks;
// /*
//  * Problem Description
// Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

import java.util.Stack;

// String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

// Find and return the postfix expression of A.

// NOTE:

// ^ has the highest precedence.
// / and * have equal precedence but greater than + and -.
// + and - have equal precedence and lowest precedence among given operators.


// Problem Constraints
// 1 <= length of the string <= 500000



// Input Format
// The only argument given is string A.



// Output Format
// Return a string denoting the postfix conversion of A.



// Example Input
// Input 1:

//  A = "x^y/(a*z)+b"
// Input 2:

//  A = "a+b*(c^d-e)^(f+g*h)-i"


// Example Output
// Output 1:

//  "xy^az*/b+"
// Output 2:

// "abcd^e-fgh*+^*+i-"


// Example Explanation
// Explanation 1:

// Ouput dentotes the postfix expression of the given input.
//  */
public class infixTopostfix {
        public String solve(String A) {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (Character.isLetter(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    output.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    output.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop());
        }
        return output.toString();
    }
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    private int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
