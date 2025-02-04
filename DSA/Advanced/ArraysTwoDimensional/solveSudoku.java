package DSA.Advanced.ArraysTwoDimensional;
/*
Problem No -38
 Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
 */

/* 
 
Code Explanation Step by Step


solveSudoku Method: This method is the entry point. It calls the solve Method to start solving the Sudoku puzzle.
solve Method: The solve method is the core of the backtracking algorithm.

Nested Loop for Each Cell

1.for (int row = 0; row < 9; row++) { for (int col = 0; col < 9; col++) {: These nested loops iterate through each cell of the Sudoku board.

2. Check for Empty Cell (if (board[row][col] == ‘.’)): This condition checks if the current cell is empty (contains '.'). If it is, the code proceeds to fill the cell.

3. Try Numbers in the Cell (for (char num = ‘1’; num <= ‘9’; num++)): This loop iterates through numbers from '1' to '9' and tries placing each number in the empty cell.

4. Check Validity of Number (if (isValid(board, row, col, num))): This condition checks if placing the current number (num) in the current cell is valid by calling the isValid method.

5. Place Number and Recur:

board[row][col] = num: If placing the number is valid, the code sets the cell to the chosen number.
if (solve(board)) { return true; }: The method then recursively calls itself (solve(board)) to continue solving the rest of the puzzle. If a solution is found, it returns true.
6. Backtrack: Undo the Choice (board[row][col] = ‘.’): If the recursive call doesn't lead to a solution, the choice is undone by resetting the cell to '.' (backtracking).

7. Check Next Number: The loop continues to the next iteration, trying the next number.

8. Return False if No Valid Number Found: If no valid number is found for the current empty cell, the method returns false.

9. Return True if All Cells Filled: If the nested loops complete without encountering an empty cell, it means all cells are filled, and the method returns true.

isValid Method:

Declares a private boolean method isValid that checks whether placing a number in a specific cell violates Sudoku rules. This method takes the Sudoku board (board), the current row and column indices (row and col), and the number (num) to be checked for validity.

Loop Over Rows, Columns, and Sub-boxes: This loop for (int i = 0; i < 9; i++) iterates from i = 0 to i = 8 and checks the conditions inside for each iteration.

Check in Current Row (if (board[row][i] == num)): This condition checks if the number num is already present in the current row (row). If it is, the method returns false, indicating that placing num in the current cell would violate the Sudoku rule for unique digits in each row.
Check in Current Column (if (board[i][col] == num)): This condition checks if the number num is already present in the current column (col). If it is, the method returns false, indicating a violation of the Sudoku rule for unique digits in each column.
Check in Current Sub-box:
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) : This condition checks if the number num is already present in the 3x3 sub-box that contains the current cell.
3 * (row / 3): This expression calculates the starting row index of the current 3x3 sub-box.
i / 3: This part adjusts the row index within the sub-box.
3 * (col / 3): This expression calculates the starting column index of the current 3x3 sub-box.
i % 3: This part adjusts the column index within the sub-box.
The combination ensures that the correct cell in the 3x3 sub-box is checked.
If num is already present in the sub-box, the method returns false.
Return Result: If none of the conditions in the loop are met (i.e., num is not already present in the current row, column, or sub-box), the method returns true, indicating that placing num in the current cell is valid. 

*/
public class solveSudoku {
    public static void solveSudokuPattern(char[][] board) {
        solve(board);
    }
    private static boolean solve (char[][] board){
        for(int row=0; row<9; row++){
            for (int col=0; col<9; col++){
                if (board[row][col]=='.'){
                    for(char num= '1'; num<='9'; num++){
                        if (isValid(board, row, col, num)){
                            board[row][col] = num;
                            if(solve(board)){
                                return true; //found a Solution
                            }
                            //undo the choice if it doesn't lead to a solution
                            board[row][col]='.';
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true;  // All cells are filled
    }

    private static boolean isValid(char[][] board, int row, int col, char num){
        //check if num is not already present in the current row, col and sub-box
       for (int i =0; i<9; i++){
        if(board[row][i]== num || board [i][col]== num || board [3* (row / 3) + i / 3][3 * (col / 3) + i % 3] == num){
           return false; 
        }
       }
       return true;
    }
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudokuPattern(board);
        System.out.println("Solved Sudoku:");
        printBoard(board);
    }
}
