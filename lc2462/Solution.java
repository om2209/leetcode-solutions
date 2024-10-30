import java.util.PriorityQueue;

class Solution {

    public static long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        long totalCost = 0L;
        int i = 0, j = costs.length - 1;

        while (k != 0) {
            while (queue1.size() < candidates && i <= j) {
                queue1.add(costs[i]);
                i++;
            }
            while (queue2.size() < candidates && j >= i) {
                queue2.add(costs[j]);
                j--;
            }

            int leftMin = queue1.peek() != null ? queue1.peek() : Integer.MAX_VALUE;
            int rightMin = queue2.peek() != null ? queue2.peek() : Integer.MAX_VALUE;

            if (leftMin <= rightMin) {
                totalCost += leftMin;
                queue1.poll();
            } else {
                totalCost += rightMin;
                queue2.poll();
            }

            k--;
        }

        return totalCost;
    }
}
