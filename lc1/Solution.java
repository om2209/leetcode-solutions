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
    }
}