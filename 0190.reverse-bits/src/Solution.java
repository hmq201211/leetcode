
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            int tmp = n >>> i;
            tmp = tmp & 1;
            tmp = tmp << (31 - i);
            result |= tmp;
        }
        return result;
    }
}