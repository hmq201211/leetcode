class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int index = 2; index < cost.length; index++) {
            dp[index] = Math.min(dp[index - 1], dp[index - 2]) + cost[index];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }
}