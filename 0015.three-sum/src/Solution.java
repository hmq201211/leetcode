import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * @Description: threeSum
     * we have 3 pointers current, left and right
     * we do a sort first and try to move the current and let left be current + 1 and right be the last one
     * special case one: if the number of the current is bigger than 0 , then we can say there will not have one solution further, since we have sorted order.
     * special case two: if the current number is the same as current before, we just continue to skip this iteration.
     * then we have the common case: the left number plus the right number maybe the negative of the current number.
     * Be care of the repetitions of the left index and right index
     * @Params: [nums]
     * @Create: 2019/12/4 22:29
     * @Return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return toReturn;
        }
        final int length = nums.length;
        int current;
        int left;
        int right;
        int candidateSum;
        Arrays.sort(nums);
        for (current = 0; current < length; current++) {
            if (nums[current] > 0)
                break;
            if (current - 1 >= 0 && nums[current] == nums[current - 1]) {
                continue;
            }
            left = current + 1;
            right = length - 1;
            while (left < right) {
                candidateSum = nums[current] + nums[left] + nums[right];
                if (candidateSum == 0) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[current]);
                    oneResult.add(nums[left]);
                    oneResult.add(nums[right]);
                    toReturn.add(oneResult);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (candidateSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 0};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(test);
        System.out.println(result);
    }
}