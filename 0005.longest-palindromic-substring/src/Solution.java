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

    private String initString(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('#');
        for (int i = 0; i < length; i++) {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append('#');
        }
        return stringBuilder.toString();
    }


    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String newString = initString(s);
        int newLength = newString.length();
        int[] p = new int[newLength];
        int mx = 0;
        int id = 0;
        int maxI = 0;
        int longestLength = 1;
        boolean needCompute;
        for (int i = 0; i < newLength; i++) {
            if (i < mx) {
                if (p[2 * id - i] < mx - i) {
                    p[i] = p[2 * id - i];
                    needCompute = false;
                } else {
                    p[i] = mx - i;
                    needCompute = true;
                }
            } else {
                p[i] = 1;
                needCompute = true;
            }
            if (needCompute)
                while (i - p[i] >= 0 && i + p[i] < newLength && newString.charAt(i - p[i]) == newString.charAt(i + p[i])) {
                    p[i]++;
                }

            if (i + p[i] > mx) {
                mx = p[i] + i;
                id = i;
            }
            if (p[i] > longestLength) {
                maxI = i;
                longestLength = p[i];
            }
            System.out.println("-----------");
            for (int j : p) {
                System.out.print(j);
                System.out.print(' ');
            }
            System.out.println("-----------");
            for (int k = 0; k < newLength; k++) {
                System.out.print(newString.charAt(k));
                System.out.print(' ');
            }
            System.out.println("-----------");
        }
        return newString.substring(maxI - p[maxI] + 1, maxI + p[maxI]).replace("#", "");
    }

    public static void main(String[] args) {
        String test = "abccbasdduadjasddddjdsjdjsjdsjd";
        Solution solution = new Solution();
        String toReturn = solution.longestPalindrome2(test);
        String correct = solution.longestPalindrome(test);
        System.out.println(correct);
        System.out.println(toReturn);
    }

    private String centerSpread(String s, int length, int centerLeft, int centerRight) {
        while (centerLeft >= 0 && centerRight < length && s.charAt(centerLeft) == s.charAt(centerRight)) {
            centerLeft--;
            centerRight++;
        }
        return s.substring(centerLeft + 1, centerRight);
    }

    public String longestPalindrome3(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeString = s.substring(0, 1);
        for (int i = 0; i < length - 1; i++) {
            String odd = centerSpread(s, length, i, i);
            String even = centerSpread(s, length, i, i + 1);
            String result = odd.length() > even.length() ? odd : even;
            if (result.length() > longestPalindrome) {
                longestPalindrome = result.length();
                longestPalindromeString = result;
            }
        }
        return longestPalindromeString;
    }


}