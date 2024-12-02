package lc694;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBFS {
    
    void bfs(int row, int col, int[][] grid, boolean[][] visited,
             List<List<Integer>> currentIsland, int baseRow, int baseCol) {

        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        int[][] directions = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            int currentRow = currentElement[0];
            int currentCol = currentElement[1];
            currentIsland.add(List.of(currentRow - baseRow, currentCol - baseCol));

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                if (isValid(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {

        return (row > -1 && row < grid.length) && (col > -1 && col < grid[0].length)
                && !visited[row][col] && grid[row][col] == 1;
    }

    int countDistinctIslands(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<List<List<Integer>>> resultSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<List<Integer>> currentIsland = new ArrayList<>();
                    bfs(i, j, grid, visited, currentIsland, i, j);
                    resultSet.add(currentIsland);
                }
            }
        }

        return resultSet.size();
    }
}
