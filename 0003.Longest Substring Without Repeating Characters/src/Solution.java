import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @Description: lengthOfLongestSubstring2
     * 使用HashSet来维护一个窗口,
     * 进来一个char,
     * 如果char在窗口里面那么左边坐标加一并且退去左边元素的存储,
     * 如果char不在窗口里面那么计算answer = max(answer, j - i), 并把右元素放入存储
     * @Params: [s]
     * @Create: 2019/12/1 22:59
     * @Return: int
     */
    public int lengthOfLongestSubstring2(String s) {
        int answer = 0;
        int i = 0, j = 0;
        HashSet<Character> hashSet = new HashSet<>();
        if (s == null) return answer;
        final int length = s.length();
        while (i < length && j < length) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j++));
                answer = Math.max(answer, j - i);
            } else {
                hashSet.remove(s.charAt(i++));
            }
        }
        return answer;
    }

    /**
     * @Description: lengthOfLongestSubstring3
     * 使用HashMap来替代HashSet 原因是 使用HashMap来存储char对应的index , 这样一来, 就不需要每次都查左边坐标元素是否在set里, i可以直接跳到 查到的index+1的位置
     * 每次进来一个item, 向HashMap里面放置的的是item: index+1
     * 这样如果进来的元素是重复的, 那么左边坐标为max(i, hashMap取出的index) 这是因为存储的时候已经加一了
     * 每次更新answer 的加一是因为此时j还没有加一
     * @Params: [s]
     * @Create: 2019/12/1 23:08
     * @Return: int
     */
    public int lengthOfLongestSubstring3(String s) {
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if (s == null) return answer;
        final int length = s.length();
        for (int i = 0, j = 0; j < length; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(i, hashMap.get(s.charAt(j)));
            }
            answer = Math.max(answer, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }
        return answer;
    }

    /**
     * @Description: lengthOfLongestSubstring4
     * instead of using hashmap to save the index info, we use simply int array, since we know that there are only const numbers of chars
     * which means that we have a int[128]
     * every time an item comes into the window we try to find the max(i, index_array[s.charAt(j)])
     * in this way, we can avoid the left index leaves the window( goes left)
     * then we update the answer by comparing the previous answer and current window size
     * then we update the index array. ( j + 1 means that we can get and use , j + 1 index must be the left side of the window)
     * @Params: [s]
     * @Create: 2019/12/2 10:05
     * @Return: int
     */
    public int lengthOfLongestSubstring4(String s) {
        int answer = 0;
        int[] index_array = new int[128];
        if (s == null) return answer;
        final int length = s.length();
        for (int i = 0, j = 0; j < length; j++) {
            i = Math.max(i, index_array[s.charAt(j)]);
            answer = Math.max(answer, j - i + 1);
            index_array[s.charAt(j)] = j + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        char a = 'A';
        System.out.println((int) a);
    }
}