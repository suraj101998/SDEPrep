package DSA.Advanced.Stacks;

import java.util.Stack;

/*
 * Problem Description
Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 109



Input Format
The only argument is a stack given as an integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.

 */
public class sortStackUsingAnotherStack {
        public int[] solve(int[] A) {
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> sortedStack = new Stack<>();
        for (int num : A) {
            inputStack.push(num);
        }
        while (!inputStack.isEmpty()) {
            int current = inputStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > current) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
        int[] result = new int[sortedStack.size()];
        int index = sortedStack.size() - 1;
        while (!sortedStack.isEmpty()) {
            result[index--] = sortedStack.pop();
        }
        return result;
    }
}
