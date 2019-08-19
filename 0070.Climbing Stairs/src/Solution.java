import jdk.nashorn.internal.ir.ReturnNode;

class Solution {
    public int climbStairs(int n) {
        return climb_stairs(0, n);
    }

    private int climb_stairs(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        return climb_stairs(start + 1, end) + climb_stairs(start + 2, end);
    }

    public int climbStairs_2(int n) {
        int[] memo = new int[n + 1];
        return climb_stairs_2(0, n, memo);
    }

    private int climb_stairs_2(int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (memo[start] > 0) {
            return memo[start];
        }
        memo[start] = climb_stairs_2(start + 1, end, memo) + climb_stairs_2(start + 2, end, memo);
        return memo[start];
    }

    public int climbStairs_3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int index = 3; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

    public int climbStairs_4(int n) {
        if (n == 1) {
            return 1;
        }
        int head = 1;
        int next = 2;
        int temp;
        for (int index = 3; index <= n; index++) {
            temp = head + next;
            head = next;
            next = temp;
        }
        return next;
    }
}