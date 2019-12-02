import javax.sound.midi.Soundbank;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] - prices[index - 1] > 0) {
                profit = profit + prices[index] - prices[index - 1];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = Math.max(0, Integer.MIN_VALUE);
                dp[i][1] = Math.max(Integer.MIN_VALUE, - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n-1][0];
    }


}
