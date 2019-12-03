/**
 * @ClassName: Leetcode->Solution
 * @Description: New
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @Author: Mingqing Hou
 * @Create: 2019-12-03 10:09
 **/
public class Solution {
    /**
     * @Description: reverse
     * each time we pick up the last digit, and ans = ans * 10 + digit
     * positive overflow : case 1: ans > max_value / 10
     * case 2: ans == max_value / 10 and the last digit is more than 7
     * negative overflow : case 1: ans < min_value / 10
     * case 2: ans == min_value / 10 and the last digit is less than -8
     * @Params: [x]
     * @Create: 2019/12/3 10:15
     * @Return: int
     */
    public int reverse(int x) {
        int toReturn = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (toReturn > Integer.MAX_VALUE / 10 || (toReturn == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (toReturn < Integer.MIN_VALUE / 10 || (toReturn == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            toReturn = toReturn * 10 + lastDigit;
            x /= 10;
        }
        return toReturn;
    }
}
