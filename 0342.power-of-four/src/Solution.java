class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        if ((num & (num - 1)) != 0) {
            return false;
        }
        return (num & 0x55555555) == num;
    }
}