package lc785;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {
    
    public boolean isBipartiteUtil(int node, int[][] graph, int[] color) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1 && !isBipartiteUtil(i, graph, color)) {
                return false;
            }
        }

        return true;
    }
}
