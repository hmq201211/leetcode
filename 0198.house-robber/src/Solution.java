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

    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }
        return Math.max(dp[nums.length - 2], dp[nums.length - 1]);
    }
}