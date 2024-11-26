import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        List<Map.Entry<Integer, Integer>> numsWithIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsWithIndices.add(Map.entry(nums[i], i));
        }
        numsWithIndices.sort(Map.Entry.comparingByKey());
        int left = 0;
        int right = numsWithIndices.size() - 1;
        while (left < right) {
            if ((numsWithIndices.get(left).getKey() + numsWithIndices.get(right).getKey() == target)) {
                break;
            } else if ((numsWithIndices.get(left).getKey() + numsWithIndices.get(right).getKey() > target)) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {left, right};
    }
}