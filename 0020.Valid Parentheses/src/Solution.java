import javax.swing.*;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * @Description: isValid
     * we have a hashmap to store the key value pair of the mapping
     * we have a stack container to help us do the validation
     * if have a key then we push it to the stack
     * if we have a value then we look the top of the stack if that item's mapping value is the same as the current one
     * we say that this single validation is correct, and we can continue
     * if the stack is empty or the mapping is wrong, then we just return false.
     * @Params: [s]
     * @Create: 2019/12/5 10:06
     * @Return: boolean
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (hashMap.containsKey(temp)) {
                stack.push(temp);
            }
            if (hashMap.containsValue(temp)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (temp != hashMap.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
