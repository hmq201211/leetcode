import java.awt.print.Printable;
import java.util.PrimitiveIterator;

class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes2(5));
    }
}