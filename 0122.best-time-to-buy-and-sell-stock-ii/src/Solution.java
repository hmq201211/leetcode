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
}
