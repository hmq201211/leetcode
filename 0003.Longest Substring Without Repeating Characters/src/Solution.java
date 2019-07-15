import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < length; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(i, hashMap.get(s.charAt(j)));
            }
            answer = Math.max(answer, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }
        return answer;
    }
}