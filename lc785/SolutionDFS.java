package lc785;

import java.util.Arrays;

public class SolutionDFS {
    
    public boolean isBipartiteUtil(int node, int[][] graph, int[] color) {

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                color[neighbor] = 1 - color[node];
                if (!isBipartiteUtil(neighbor, graph, color)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                return false;
            }
        }
        
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!isBipartiteUtil(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }
}
