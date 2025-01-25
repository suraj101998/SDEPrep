package DSA.Advanced.DyanmicProgramming;

public class longestPathInMatrix {
    public static int findlongestPath(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j] = -1;
            }
        }
        int longestPath = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                longestPath = Math.max(longestPath, dfs(matrix, dp, i, j, rows, cols));
            }
        }
        return longestPath;
    }

    public static int dfs(int[][] matrix, int[][] dp, int row, int col, int rows, int cols){
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int[] dRow = {-1,1,0,0};
        int[] dCol = {0,0,-1,1};
        int maxPath = 1;
        for(int d=0; d<4; d++){
            int newRow = row + dRow[d];
            int newCol = col + dCol[d];
            if(newRow >=0 && newRow<rows && newCol >=0 && newCol<cols && matrix[newRow][newCol]>matrix[row][col]){
                maxPath = Math.max(maxPath, 1+dfs(matrix, dp, newRow, newCol, rows, cols));
            }
        }
        dp[row][col] = maxPath;
        return maxPath;
    }

    public static void main(String[] args){
        int[][] A = {{1,2,4,5,6},{4,5,6,7,8}};
        int result = findlongestPath(A);
        System.out.println("ans: "+result);
    }
}
