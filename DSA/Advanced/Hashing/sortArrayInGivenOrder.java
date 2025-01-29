package DSA.Advanced.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Description
Given two arrays of integers A and B, Sort A in such a way that the relative order among 
the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.

Problem Constraints
1 <= length of the array A <= 100000
1 <= length of the array B <= 100000
-10^9 <= A[i] <= 10^9


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the array A after sorting as described.


Example Input
Input 1:
A = [1, 2, 3, 4, 5, 4]
B = [5, 4, 2]

Input 2:
A = [5, 17, 100, 11]
B = [1, 100]

Example Output
Output 1:
[5, 4, 4, 2, 1, 3]

Output 2:
[100, 5, 11, 17]

Example Explanation
Explanation 1:
Since 2, 4, 5, 4 of A are present in the array B.  So Maintaining the relative order of B.
Thus, [5, 4, 4, 2] and appending the remaining element (1, 3) in sorted order.

The Final array is [5, 4, 4, 2, 1, 3]

Explanation 2:

Since 100 of A are present in the array B.  So Maintaining the relative order of B.
Thus, [100] and appending the remaining element (5, 11, 17) in sorted order.

The Final array is [100, 5, 11, 17]
 */
public class sortArrayInGivenOrder {
/*        public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : A){
            map.put(num, map.getOrDefault(num,0)+1); 
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : B){
            if(map.containsKey(num)){
                int count = map.get(num);
                while(count-- > 0){
                    result.add(num);
                }
                map.remove(num);
            }
        }
        ArrayList<Integer> remaining = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            while(count-- > 0){
                remaining.add(key);
            }
        }
        Collections.sort(remaining);
        result.addAll(remaining);
        return result;
    }
        */
  public static int[] solve (int[] A, int[] B){
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int num : A){
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    ArrayList<Integer> result = new ArrayList<>();
    for(int num : B){
      if(map.containsKey(num)){
        int count = map.get(num);
        while(count-- > 0){
          result.add(num);
        }
        map.remove(num);
      }
    }
    ArrayList<Integer> remaining = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
      int key = entry.getKey();
      int count = entry.getValue();
      while(count-- > 0){
        remaining.add(key);
      }
    }
    Collections.sort(remaining);
    result.addAll(remaining);
    return result.stream().mapToInt(i -> i).toArray();
  } 
  public static void main(String[] args) {
    int[] A= {1, 2, 3, 4, 5, 4};
    int[] B= {5, 4, 2};
    int[] result = solve(A,B);
    System.out.println("ans: "+Arrays.toString(result));
  }
}
