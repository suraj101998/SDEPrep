package ScalerProblems.DSA.Stacks;
/*Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.

Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output
Output 1:
 1 
Output 2:
 0 
Output 3:
 1 
 */
import java.util.Stack;
public class balancedParanthases {
    public int solve(String A) {
        int N = A.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<N; i++){
            char ch = A.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']'){
                if(st.isEmpty()==true){
                    return 0;
                }
                if( (ch==')' && st.peek()!='(') || (ch=='}' && st.peek()!='{') || (ch==']' && st.peek()!='[') ){
                    return 0;
                }
                else{
                    st.pop();
                }
            }
        }
        if(st.isEmpty()==true){
            return 1;
        }
        else{
            return 0;
        }
    }
}
