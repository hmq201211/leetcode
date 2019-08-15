public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int house = costs.length;
        int color = costs[0].length;
        int[][] sum = new int[house][color];
        sum[0][0] = costs[0][0];
        sum[0][1] = costs[0][1];
        sum[0][2] = costs[0][2];
        for (int i = 1; i < house; i++) {
            sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + costs[i][0];
            sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + costs[i][1];
            sum[i][2] = Math.min(sum[i - 1][1], sum[i - 1][0]) + costs[i][2];
        }
        return Math.min(sum[house - 1][0], Math.min(sum[house - 1][1], sum[house - 1][2]));
    }

    public static void main(String[] args) {
        int[][] test = new int[3][3];
        test[0][0] = 17;
        test[0][1] = 2;
        test[0][2] = 17;
        test[1][0] = 16;
        test[1][1] = 16;
        test[1][2] = 5;
        test[2][0] = 14;
        test[2][1] = 3;
        test[2][2] = 19;
        System.out.println(new Solution().minCost(test));
    }
}
