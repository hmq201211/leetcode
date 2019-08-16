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
}