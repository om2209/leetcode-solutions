import heapq
from typing import List

class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        
        queue1, queue2 = [], []
        total_cost, i, j = 0, 0,len(costs) - 1

        while k:
            while len(queue1) < candidates and i <= j:
                heapq.heappush(queue1, costs[i])
                i += 1
            while len(queue2) < candidates and j >= i:
                heapq.heappush(queue2, costs[j])
                j -= 1
            
            left_min = queue1[0] if queue1 else float('inf')
            right_min = queue2[0] if queue2 else float('inf')

            if left_min <= right_min:
                total_cost += left_min
                heapq.heappop(queue1)
            else:
                total_cost += right_min
                heapq.heappop(queue2)
            
            k -= 1

        return total_cost
