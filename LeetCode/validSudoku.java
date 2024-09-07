package LeetCode;
/*
Problem No- 36
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */


import java.util.HashSet;

/*
Code Explanation Step by Step:

HashSet Initialization:
HashSet seen = new HashSet(); initializes a HashSet named seen. This HashSet will be used to keep track of unique elements encountered during the traversal of the Sudoku board.

Board Traversal:
I use nested loops to iterate through each cell of the 9x9 Sudoku board using variables i and j which represent row and column of the borad.

Checking Non-Empty Cells:
if(board[i][j] != '.'): This condition checks if the current cell is not empty (i.e., the cell value is not '.'). If the cell is empty, no action is taken for that cell.

Unique String Representations:
I use unique string representations for each digit in a row, column, and 3x3 sub-box. Consider above 9x9 Sadako board where we are checking digit “9” position in row, column and 3x3 sub-box in string representation. Digit “9” is located at i = 1 and j = 5
So string representation of row, column and sub-box will be as below:
row = "row"+i+board[i][j] = "row" + 1 + 9
col= "col"+i+board[i][j] = "row" + 5 + 9
box= "box" + (i/3)*3 +j/3 + board[i][j] = "box"+ 2 + 9

How to calculate sub-box ?
9x9 Sadako borad has 9 sub-boxes starting from 0 to 8. Below formula will give the sub-box:
box = (i/3)*3 +j/3)

seen.add("row"+i+board[i][j]): Adds a string representing the digit and its position in the current row to the seen HashSet.
seen.add("col"+j+board[i][j]): Adds a string representing the digit and its position in the current column to the seen HashSet.
seen.add("box" + (i/3)*3 +j/3 + board[i][j]): Adds a string representing the digit and its position in the current 3x3 sub-box to the seen HashSet.

Checking Uniqueness:
The code uses the add method of the HashSet to attempt to add each unique string to the seen HashSet.
If add returns false, it means the same string (representing the same digit in the same context) has been added before, indicating a violation of the Sudoku rules.

Returning Validity:
If any violation is detected during the traversal, the function returns false, indicating that the Sudoku board is not valid.
If the traversal completes without encountering any violations, the function returns true, indicating that the Sudoku board is valid.
 */
public class validSudoku {
     @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet();

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] != '.'){

                    if(!seen.add("row"+i+board[i][j]) || !seen.add("col"+j+board[i][j]) || !seen.add("box" + (i/3)*3 +j/3 + board[i][j] )){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
