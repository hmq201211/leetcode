public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit = Math.max(profit, prices[i] - min);
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dailyProfit = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - prices[i - 1];
            dailyProfit[i - 1] = value;
        }
        int localeMaximum = 0;
        int globalMaximum = 0;
        for (int i = 0; i < dailyProfit.length; i++) {
            localeMaximum = Math.max(localeMaximum + dailyProfit[i], dailyProfit[i]);
            if (globalMaximum < localeMaximum) {
                globalMaximum = localeMaximum;
            }
        }
        return globalMaximum;
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        return dp[n - 1][0];
    }
}
