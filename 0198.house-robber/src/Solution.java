class Solution {
    public int rob(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
                sumEven = Math.max(sumEven, sumOdd);
            } else {
                sumOdd += nums[i];
                sumOdd = Math.max(sumEven, sumOdd);
            }
        }
        return Math.max(sumOdd, sumEven);
    }

    public int rob2(int[] nums) {
        int pre_pre = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = pre;
            pre = Math.max(pre_pre + nums[i], pre);
            pre_pre = temp;
        }
        return pre;

    }
}