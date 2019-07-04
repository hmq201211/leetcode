import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('[', ']');
        hm.put('{', '}');
        hm.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            if (hm.containsKey(s.charAt(index))) {
                stack.push(s.charAt(index));
            }
            if (hm.containsValue(s.charAt(index))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (hm.get(stack.pop()) != s.charAt(index)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
