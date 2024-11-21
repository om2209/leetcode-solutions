from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_with_indices = [(nums[i], i) for i in range(len(nums))]
        nums_with_indices.sort(key = lambda x: x[0])

        left, right = 0, len(nums_with_indices) - 1
        while left < right:
            if (nums_with_indices[left][0] + nums_with_indices[right][0]) == target:
                break
            elif (nums_with_indices[left][0] + nums_with_indices[right][0]) > target:
                right -= 1
            else:
                left += 1

        return [nums_with_indices[left][1], nums_with_indices[right][1]]