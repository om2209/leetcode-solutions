package lc694;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class SolutionDFS {

    void dfs(int currentRow, int currentCol, int[][] grid, boolean[][] visited,
             ArrayList<Map.Entry<Integer, Integer>> currentIsland, int baseRow, int baseCol) {

        visited[currentRow][currentCol] = true;
        currentIsland.add(Map.entry(currentRow - baseRow, currentCol - baseCol));

        int[][] directions = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] direction: directions) {
            int newRow = currentRow + direction[0];
            int newCol = currentCol + direction[1];
            if (isValid(newRow, newCol, grid, visited)) {
                dfs(newRow, newCol, grid, visited, currentIsland, baseRow, baseCol);
            }
        }
    }

    boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {

        return (row > -1 && row < grid.length) && (col > -1 && col < grid[0].length)
                && !visited[row][col] && grid[row][col] == 1;
    }

    int countDistinctIslands(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<ArrayList<Map.Entry<Integer, Integer>>> resultSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<Map.Entry<Integer, Integer>> currentIsland = new ArrayList<>();
                    dfs(i, j, grid, visited, currentIsland, i, j);
                    resultSet.add(currentIsland);
                }
            }
        }

        return resultSet.size();
    }
}
