package lc200;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SolutionBFS {
    
    public void bfs(int row, int col, char[][] grid, boolean[][] visited) {

        visited[row][col] = true;
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(row, col));

        while (!queue.isEmpty()) {
            Integer currentRow = queue.peek().getKey();
            Integer currentCol = queue.peek().getValue();
            queue.poll();

            if ((currentRow+1)<grid.length && !visited[currentRow+1][currentCol] && grid[currentRow+1][currentCol] == '1') {
                visited[currentRow+1][currentCol] = true;
                queue.add(Map.entry(currentRow+1, currentCol));
            }
            if ((currentRow-1)>-1 && !visited[currentRow-1][currentCol] && grid[currentRow-1][currentCol] == '1') {
                visited[currentRow-1][currentCol] = true;
                queue.add(Map.entry(currentRow-1, currentCol));
            }
            if ((currentCol+1)<grid[0].length && !visited[currentRow][currentCol+1] && grid[currentRow][currentCol+1] == '1') {
                visited[currentRow][currentCol+1] = true;
                queue.add(Map.entry(currentRow, currentCol+1));
            }
            if ((currentCol-1)>-1 && !visited[currentRow][currentCol-1] && grid[currentRow][currentCol-1] == '1') {
                visited[currentRow][currentCol-1] = true;
                queue.add(Map.entry(currentRow, currentCol-1));
            }
        }
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
