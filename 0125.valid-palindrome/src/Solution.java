class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals(""))
            return true;
        int head = 0;
        int tail = s.length() - 1;
        while (tail > head) {
            while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            }
            while (tail > head && !Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }
        return true;

    }
}