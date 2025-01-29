package DSA.Advanced.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a staircase with n steps, 
 * you can walk 1 step, leap 2 steps or jump 3 steps at a time. 
 * print all unique ways to climb the stairs. using recursion and backtracking explore all posiible ways. 
 * store and print each unique path to the top.
 */
public class climbingStairsJumps {
    public static void findPaths(int stepsRemained, List<Integer> currentPath, List<List<Integer>> allPaths){
        if(stepsRemained == 0){
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        if(stepsRemained<0){
            return;
        }
        currentPath.add(1);
        findPaths(stepsRemained-1, currentPath, allPaths);
        currentPath.remove(currentPath.size()-1);

        currentPath.add(2);
        findPaths(stepsRemained-2, currentPath, allPaths);
        currentPath.remove(currentPath.size()-1);

        currentPath.add(3);
        findPaths(stepsRemained-3, currentPath, allPaths);
        currentPath.remove(currentPath.size()-1);
    }
    public static void main(String[] args){
        int n = 4;
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(n, currentPath, allPaths);
        for(List<Integer> result: allPaths){
            System.out.println(result);
        }
    }
}
