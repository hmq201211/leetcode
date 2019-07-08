class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int index = 1; index < nums.length; index++) {
            if (count == 0) {
                major = nums[index];
            }
            if (major == nums[index]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}