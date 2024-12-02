package lc200;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SolutionBFS {
    
    public void bfs(int row, int col, char[][] grid, boolean[][] visited) {

        visited[row][col] = true;
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(row, col));

        int[][] directions = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while (!queue.isEmpty()) {
            Integer currentRow = queue.peek().getKey();
            Integer currentCol = queue.peek().getValue();
            queue.poll();

            for (int[] direction: directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (isValid(grid, visited, newRow, newCol)) {
                    visited[newRow][newCol] = true;
                    queue.add(Map.entry(newRow, newCol));
                }
            }
        }
    }

    public boolean isValid(char[][] grid, boolean[][] visited, int row, int col) {
        return (row > -1 && row < grid.length) && (col > -1 && col < grid[0].length) && !visited[row][col] 
                && grid[row][col] == '1'; 
    }

    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        
        return result;
    }
}
