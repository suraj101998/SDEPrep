package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

Problem Constraints
0 <= number of nodes <= 105

Input Format
First and only arument is a pointer to the root node of binary tree, A.

Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.

Example Input
Input 1:
      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:
      1
    /   \
   3     7
  /       \
 2         9

Example Output
Output 1:
 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:
 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class verticalOrdertraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeMap<Integer, ArrayList<Integer>> verticalMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int verticalLevel = current.level;
            verticalMap.putIfAbsent(verticalLevel, new ArrayList<>());
            verticalMap.get(verticalLevel).add(node.val);
            if (node.left != null) {
                queue.add(new Pair(node.left, verticalLevel - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, verticalLevel + 1));
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> values : verticalMap.values()) {
            result.add(values);
        }
        return result;
    }
    private static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }    
}
