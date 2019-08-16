import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = Arrays.copyOf(nums, nums.length);
        int maxValue = nums[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i - 1] >= 0) {// 这里result数组是记录了以i结尾的最大子序和
                result[i] = result[i - 1] + nums[i];
            }
            if (result[i] > maxValue) {
                maxValue = result[i];
            }
        }
        return maxValue;
    }
}