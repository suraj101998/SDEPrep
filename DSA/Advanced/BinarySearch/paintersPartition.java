package DSA.Advanced.BinarySearch;
/*
Calculate and return the minimum time required to paint all boards under the constraints that 
any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, 
a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. 
This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.

Output Format
Return minimum time required to paint all boards under the constraints that 
any painter will only paint contiguous sections of board % 10000003.

Example Input
Input 1:
 A = 2
 B = 5
 C = [1, 10]

Input 2:
 A = 10
 B = 1
 C = [1, 8, 11, 3]

Example Output
Output 1:
 50
Output 2:
 11

Example Explanation
Explanation 1:
 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003

Explanation 2:
 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, 
 painter 3 paints block 3 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003
*/

/*
 * 
Approach:
1. Initialization:
    Calculate the longest board (longestBoard) and the total length of all boards (totalBoardLength).
    These determine the range for binary search:
    l = longestBoard (minimum time to paint the longest board).
    r = totalBoardLength (maximum time if one painter paints all boards).
2. Binary Search:
    Perform binary search to find the minimum possible time (minimumTimeRequired) such that 
    all boards can be painted using A painters.
    For a mid-point mid in the binary search:
    Check if it is possible to paint all boards within mid time using the helper function isPossible.
3. Feasibility Check (isPossible):
    Iterate over all boards and allocate them to painters such that no painter exceeds the maxAllowedTime.
    If allocating boards requires more than A painters, return false.
    Otherwise, return true.
4. Result:
    The result is the minimum time multiplied by the time per unit (B) modulo.

TC= O(Nlog(totalBoardLength))
    O(N) to check feasibility for each mid-point in the binary search.
    O(log(totalBoardLength)) for the binary search.
SC= O(1)
 */
public class paintersPartition {
    public static int paint(int A, int B, int[] C) {
        int MOD = 10000003;
        int longestBoard = 0;
        long totalBoardLength = 0;

        // find the longest board and the total length of all boards
        for (int boardLength : C) {
            longestBoard = Math.max(longestBoard, boardLength);
            totalBoardLength += boardLength;
        }

        // Step 2: Binary search to find the minimum time required
        long l = longestBoard;  // Minimum time is least the time to paint the longest board
        long r = totalBoardLength;  // Maximum time is if one painter paints all the boards
        long minimumTimeRequired = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (isPossible(mid, A, C)) {
                minimumTimeRequired = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // Step 3: Return the minimum time multiplied by the time per unit, mod the result
        return (int)((minimumTimeRequired * B) % MOD);
    }

    // check if it is feasible to paint all boards within maxAllowedTime
    private static boolean isPossible(long maxAllowedTime, int A, int[] C) {
        int numberOfPaintersUsed = 1;
        long timeSpentByCurrentPainter = 0;

        for (int boardLength : C) {
            // Check if the current painter can paint the next board
            if (timeSpentByCurrentPainter + boardLength > maxAllowedTime) {
                numberOfPaintersUsed++;
                timeSpentByCurrentPainter = boardLength; // Assign the new painter and reset the time

                if (numberOfPaintersUsed > A) {
                    return false;
                }
            } else {
                timeSpentByCurrentPainter += boardLength; // Accumulate time for the current painter
            }
        }
        return true;
    }
    public static void main(String[] args){
        int A = 10;
        int B = 1;
        int[] C = {1, 8, 11, 3};
        int result = paint(A, B, C);
        System.out.println("ans: "+result);
    }
}
