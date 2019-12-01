import java.util.HashMap;

/**
 * @ClassName: Leetcode->Solution
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Mingqing Hou
 * @Create: 2019-11-30 22:58
 **/
public class Solution {
    /**
     * @Description: twoSum,
     * use a HashMap to store key: actual number value: index
     * @Params: [nums, target]
     * @Create: 2019/11/30 23:11
     * @Return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0)
            return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                result[0] = map.get(target - nums[index]);
                result[1] = index;
            } else {
                map.put(nums[index], index);
            }
        }
        return result;
    }
}

