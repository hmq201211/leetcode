import javax.sound.midi.Soundbank;

public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int same = k;
        int different = k * (k - 1);
        int total = 0;
        for (int i = 3; i <= n; i++) {
            int newDifferent1 = same * (k - 1);
            same = different;
            different = newDifferent1 + different * (k - 1);
            total = same + different;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
    }
}
