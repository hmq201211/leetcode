class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return s;
        }
        int longestLength = 1;
        String toReturn = s.substring(0, 1);
        boolean[][] isPalindrome = new boolean[size][size];
        for (int r = 1; r < size; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || isPalindrome[l + 1][r - 1])) {
                    isPalindrome[l][r] = true;
                    if (r - l + 1 > longestLength) {
                        longestLength = r - l + 1;
                        toReturn = s.substring(l, r + 1);
                    }
                }
            }
        }
        return toReturn;
    }
}