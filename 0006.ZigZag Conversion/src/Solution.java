import sun.security.util.Length;

import javax.sound.midi.Soundbank;

/**
 * @ClassName: Leetcode->Solution
 * @Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Mingqing Hou
 * @Create: 2019-12-03 09:29
 **/
public class Solution {
    /**
     * @Description: convert
     * we have numRows string builders and we do zig zag appending to those builders.
     * finally, we append sbs[1:numRows} to sbs[1]
     * and return sbs[1].toString()
     * @Params: [s, numRows]
     * @Create: 2019/12/3 9:30
     * @Return: java.lang.String
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        final int Length = s.length();
        int i = 0;
        while (i < Length) {
            for (int j = 0; j < numRows && i < Length; j++) {
                stringBuilders[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < Length; j--) {
                stringBuilders[j].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            stringBuilders[0].append(stringBuilders[j]);
        }
        return stringBuilders[0].toString();
    }

    public static void main(String[] args) {
        String test = "LEETCODEISHIRING";
        int numRows = 4;
        Solution solution = new Solution();
        System.out.println(solution.convert(test, numRows));
    }
}
