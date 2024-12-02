package lc207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    
    // BFS algo for detecting a cycle (Topo sort using Kahn's algo)
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = buildGraph(numCourses, prerequisites);
        int[] inDegree = buildInDegree(numCourses, prerequisites);

        return isTopologicalSortPossible(numCourses, inDegree, adjList);
    }

    private int[] buildInDegree(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        return inDegree;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        return adjList;
    }

    private boolean isTopologicalSortPossible(int numCourses, int[] inDegree, List<List<Integer>> adj) {

        Queue<Integer> queue = new LinkedList<>();
        int processedNodes = 0;

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            processedNodes++;

            for (Integer neighbor: adj.get(currentNode)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return processedNodes == numCourses;
    }
}
