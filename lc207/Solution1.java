package lc207;

import java.util.ArrayList;

public class Solution1 {
    
    // DFS algo for cycle detection
    public boolean isCyclePresent(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour: adj.get(node)) {
            if (!visited[neighbour] && isCyclePresent(neighbour, adj, visited, pathVisited)) {
                return true;
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclePresent(i, adj, visited, pathVisited)) {
                return false;
            }
        }
        return true;
    }
}
