import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return toReturn;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int targetPointer;
        int smallPointer;
        int bigPointer;
        int tempResult;
        List<Integer> oneResult;
        for (targetPointer = 0; targetPointer < length; targetPointer++) {
            if (nums[targetPointer] > 0) {
                break;
            }
            if (targetPointer - 1 >= 0 && nums[targetPointer] == nums[targetPointer - 1]) {
                continue;
            }
            smallPointer = targetPointer + 1;
            bigPointer = length - 1;
            while (smallPointer < bigPointer) {
                tempResult = nums[targetPointer] + nums[smallPointer] + nums[bigPointer];
                if (tempResult == 0) {
                    oneResult = new ArrayList<>();
                    oneResult.add(nums[targetPointer]);
                    oneResult.add(nums[smallPointer]);
                    oneResult.add(nums[bigPointer]);
                    toReturn.add(oneResult);
                    while (smallPointer < bigPointer && nums[smallPointer] == nums[smallPointer + 1]) {
                        smallPointer++;
                    }
                    while (smallPointer < bigPointer && nums[bigPointer] == nums[bigPointer - 1]) {
                        bigPointer--;
                    }
                    smallPointer++;
                    bigPointer--;
                } else if (tempResult > 0) {
                    bigPointer--;
                } else {
                    smallPointer++;
                }
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 0};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(null);
        System.out.println(result);
    }
}