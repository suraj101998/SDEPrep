package DSA.Advanced.DyanmicProgramming;

import java.util.ArrayList;

/*
 * Problem Description

You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
Given 2 towns find whether you can reach the first town from the second without repeating any edge.
B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints
1 <= N <= 100000

Input Format
First argument is vector A
Second argument is integer B
Third argument is integer C

Output Format
Return 1 if reachable, 0 otherwise.

Example Input
Input 1:
 A = [1, 1, 2]
 B = 1
 C = 2

Input 2:
 A = [1, 1, 2]
 B = 2
 C = 1

Example Output
Output 1:
 0

Output 2:
 1

Example Explanation
Explanation 1:
 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.

 Explanation 2:
 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */
public class firstDepthFirstSearch {
  static int maxn = 100009;
  static int[] vis = new int[maxn];
  static ArrayList < ArrayList < Integer > > adj;
  public static void graph() {
    adj = new ArrayList < ArrayList < Integer > > (maxn);
    for (int i = 0; i < maxn; i++) {
      vis[i] = 0;
      adj.add(new ArrayList < Integer > ());
    }
  }
  public static int solve(int[] A, final int B, final int C) {
    graph();
    int n = A.length;
    for (int i = 1; i < n; i++) {
      adj.get(A[i]).add(i + 1);
    }
    if (dfs(C, B) == true)
      return 1;
    return 0;
  }
  public static boolean dfs(int s, int x) {
    if (s == x)
      return true;
    vis[s] = 1;
    int i, j, k = adj.get(s).size();
    for (i = 0; i < k; i++) {
      j = adj.get(s).get(i);
      if (vis[j] == 0 && dfs(j, x) == true)
        return true;
    }
    return false;
  }
  public static void main(String[] args){
    int[] A={1, 1, 2};
    int B= 1;
    int C = 2;
    int result = solve(A, B, C);
    System.out.println("ans: "+result);
  }    
}
