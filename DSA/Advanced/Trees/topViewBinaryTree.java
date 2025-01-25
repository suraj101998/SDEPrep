package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the top view of the binary tree.

Example Input
Input 1: 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:
 
            1
           /  \
          2    3
           \
            4
             \
              5

Example Output
Output 1:
 [1, 2, 4, 8, 3, 7]
Output 2:
 [1, 2, 3]

Example Explanation
Explanation 1:
Top view is described.
Explanation 2:
Top view is described.
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

public class topViewBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;
            topViewMap.putIfAbsent(hd, node.val);
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value : topViewMap.values()) {
            result.add(value);
        }
        return result;
    }
    private static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }    
}
