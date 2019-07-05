class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int test = 0;
        for (int i : nums) {
            test = test ^ i;
        }
        return test;
    }

    public static void main(String[] args) {
        System.out.println(3^2^3);
    }
}