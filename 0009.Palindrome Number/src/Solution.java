/**
 * @ClassName: Leetcode->Solution
 * @Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Mingqing Hou
 * @Create: 2019-12-03 11:05
 **/
public class Solution {
    /**
     * @Description: isPalindrome
     * special situations: negative integers isn't palindrome
     *                     if the last digit is zero , the integer must be zero = > is palindrome otherwise is not palindrome
     * we do half reverse, and stop when x is not bigger than the reversed int
     * if the integer has even length, then x and reversed int must be equal to meet the palindrome condition
     * if the integer has odd length , then x and reversed int / 10 must be equal to meet the palindrome condition
     * @Params: [x]
     * @Create: 2019/12/3 11:06
     * @Return: boolean
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedInt = 0;
        while (x > reversedInt) {
            reversedInt = reversedInt * 10 + x % 10;
            x /= 10;
        }
        return x == reversedInt || x == reversedInt / 10;
    }
}
