/*
Right Shift an Array
Problem Description
        Write a program that reads an integer array A from input and modifies the array by shifting each element to the right by one position and by shifting the last element to the first position.
        After performing the shifting operation, print the modified array.
        Note: Ensure there is a space character (‘ ‘) at the end of the line.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 109

        Input Format
        The first line of the input is the size of the array N. The second line of the input is N integers of the array separated by space.
        Output Format
        Print each element of the array, followed by a space (including the last element).

        Example
        Input:
        5
        1 2 3 4 5
        Output : 5 1 2 3 4

        Example Explanation: The elements 1, 2, 3 and 4 have been shifted to the right by one position and 5 has been moved to the first position.
*/

package ScalerProblems.SAT;
import java.util.*;

public class arrayShiftRight {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i<n; i++){
                array[i] = sc.nextInt();
            }
            if (n >1){
                int lastElement = array[n-1];
                for (int i = n-1; i>0; i--){
                    array[i] = array[i-1];
                }
                array[0] =lastElement;
            }
            for (int i =0; i<array.length; i++){
                System.out.print(array[i]+ " ");
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("An error occured: "+e.getMessage());
        }finally{
            sc.close();
        }
    }
}