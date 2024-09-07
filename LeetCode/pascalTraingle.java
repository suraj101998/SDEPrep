package LeetCode;
/*
Problem No- 118
 Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
 */


import java.util.ArrayList;
import java.util.List;

public class pascalTraingle {
        public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        f.add(List.of(1));
        for(int i= 0; i< numRows-1; ++i){
            List<Integer> g = new ArrayList<>();
            g.add(1);
            for(int j = 0; j<f.get(i).size()-1; ++j){
                g.add(f.get(i).get(j) + f.get(i).get(j+1));
            }
            g.add(1);
            f.add(g);
        }
        return f;
    }
}
