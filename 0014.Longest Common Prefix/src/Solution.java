/**
 * @ClassName: Leetcode->Solution
 * @Description: Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Mingqing Hou
 * @Create: 2019-12-03 23:00
 **/
public class Solution {
    /**
     * @Description: longestCommonPrefixHorizontalScan
     * Horizontal Scan
     * we use strs[0] as prefix then we loop over all the other strs,
     * use indexof to find the if the prefix exists in the str or not
     * if not we remove the last digit of the prefix and then re test. if the prefix becomes empty then just return "",
     * cause no matching
     * if we find matching, and then continue testing next str.
     * @Params: [strs]
     * @Create: 2019/12/3 23:01
     * @Return: java.lang.String
     */
    public String longestCommonPrefixHorizontalScan(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * @Description: longestCommonPrefixVerticalScan
     * Vertical Scan
     * this time we use vertical scan instead;
     * we loop over the chars in strs[0]
     * and compare with the char in that digit in the other strs
     * if we find that the digit in on str is empty or the char is different
     * we say that matching is over, we just return the chars before
     * if we loop over all the chars and the checking is all good.
     * then strs[0] is exactly the prefix we need.
     * @Params: [strs]
     * @Create: 2019/12/4 15:30
     * @Return: java.lang.String
     */
    public String longestCommonPrefixVerticalScan(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * @Description: longestCommonPrefixDivideAndConquer
     * Divide and conquer Approach
     * @Params: [strs]
     * @Create: 2019/12/4 15:46
     * @Return: java.lang.String
     */
    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixDivideAndConquer(strs, 0, strs.length - 1);
    }

    /**
     * @Description: longestCommonPrefixDivideAndConquer
     * divide and conquer step in the divide and conquer approach in longest common prefix question.
     * Mainly, it takes two part of strs find their longest common prefix and return the longest common prefix of those two parts
     * if the left index is the same as the right index
     * then just return strs[index]
     * then we split the question into two smaller questions.
     * the left part and right part
     * and return the longest common prefix of these two parts.
     * @Params: [strs, left, right]
     * @Create: 2019/12/4 16:20
     * @Return: java.lang.String
     */

    private String longestCommonPrefixDivideAndConquer(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int middle = (left + right) / 2;
        String prefix_left = longestCommonPrefixDivideAndConquer(strs, left, middle);
        String prefix_right = longestCommonPrefixDivideAndConquer(strs, middle + 1, right);
        return longestCommonPrefix(prefix_left, prefix_right);
    }

    /**
     * @Description: longestCommonPrefix
     * helper function for divide and conquer approach in longest common prefix question.
     * find the minimum length then loop over the two string one by one digit.
     * if the digit doesn't match then return the matched chars before.
     * if the loop is over , that means the smaller one is totally contained in the bigger one,
     * we just return the smaller one.
     * @Params: [left, right]
     * @Create: 2019/12/4 16:18
     * @Return: java.lang.String
     */
    private String longestCommonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}