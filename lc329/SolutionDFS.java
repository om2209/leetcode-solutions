package lc329;

public class SolutionDFS {
    
    public int dfs(int row, int col, int[][] matrix, int[][] dp, int prev) {

        if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length || matrix[row][col] <= prev) {
            return 0;
        }
        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }

        int result = 1;
        result = Math.max(result, 1 + dfs(row + 1, col, matrix, dp, matrix[row][col]));
        result = Math.max(result, 1 + dfs(row - 1, col, matrix, dp, matrix[row][col]));
        result = Math.max(result, 1 + dfs(row, col + 1, matrix, dp, matrix[row][col]));
        result = Math.max(result, 1 + dfs(row, col - 1, matrix, dp, matrix[row][col]));

        dp[row][col] = result;
        return result;
     }

    public int longestIncreasingPath(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(i, j, matrix, dp, -1);
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}