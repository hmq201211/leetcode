public class Solution {
    public int removeDuplicates(int[] nums) {
        final int len = nums.length;
        int low_pointer = 0;
        int fast_pointer = 0;
        for (; fast_pointer < len; fast_pointer++) {
            if (nums[low_pointer] != nums[fast_pointer]) {
                low_pointer++;
                nums[low_pointer] = nums[fast_pointer];
            }
        }
        return low_pointer + 1;
    }
}
