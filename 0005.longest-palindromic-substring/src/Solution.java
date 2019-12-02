
class Solution {
    /**
     * @Description: main
     * test method
     * @Params: [args]
     * @Create: 2019/12/2 11:24
     * @Return: void
     */
    public static void main(String[] args) {
        String test = "ababa";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeBruteForce(test));
        System.out.println(solution.longestPalindromeDynamicProgramming(test));
        System.out.println(solution.longestPalindromeManacher(test));
        System.out.println(solution.longestPalindromeCenterSpread(test));
    }

    /**
     * @Description: isPalindrome
     * helper function for brute force solution
     * it accepts a string and then test the string is palindrome or not
     * @Params: [s]
     * @Create: 2019/12/2 11:02
     * @Return: boolean
     */
    private static boolean isPalindrome(String s) {
        final int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * @Description: longestPalindromeBruteForce
     * Brute force approach to collect all the possible candidates and then test the candidate is Palindromic or not
     * if it's palindromic and its length is bigger than the max then change the answer to the candidate and update the max(length)
     * @Params: [s]
     * @Create: 2019/12/2 11:20
     * @Return: java.lang.String
     */
    public String longestPalindromeBruteForce(String s) {
        String toReturn = "";
        int max = 0;
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String candidate = s.substring(i, j);
                if (isPalindrome(candidate) && candidate.length() > max) {
                    toReturn = candidate;
                    max = candidate.length();
                }
            }
        }
        return toReturn;
    }

    /**
     * @Description: longestPalindromeDynamicProgramming
     * use a memo to help find the memo[i][j] = memo[i+1][j-1] and s.charAt(i) == s.charAt(j)
     * and we test j - i + 1 and the longest length before
     * if the new one is bigger then
     * we update the longest length and the string to return
     * @Params: [s]
     * @Create: 2019/12/2 16:38
     * @Return: java.lang.String
     */
    public String longestPalindromeDynamicProgramming(String s) {
        if (s == null) return null;
        final int length = s.length();
        if (length <= 1) return s;
        String toReturn = s.substring(0, 1);
        boolean[][] memo = new boolean[length][length];
        int longestLength = 1;
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || memo[left + 1][right - 1])) {
                    memo[left][right] = true;
                    if (right - left + 1 > longestLength) {
                        longestLength = right - left + 1;
                        toReturn = s.substring(left, right + 1);
                    }
                }
            }
        }
        return toReturn;
    }

    /**
     * @Description: createFormattedString
     * helper function for manacher approach of longestPalindrome
     * it accepts a string then use "#" to fill in the gap of the chars ( assuming that char "#" is never used in the string)
     * for example abc then we return #a#b#c#
     * advantage: by using this formatting we can turn whatever odd or even length string into odd length new string
     * @Params: [s]
     * @Create: 2019/12/2 16:48
     * @Return: java.lang.String
     */
    private String createFormattedString(String s) {
        final int length = s.length();
        if (length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i = 0; i < length; i++) {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append("#");
        }
        return stringBuilder.toString();
    }

    /**
     * @Description: longestPalindromeManacher
     * manacher approach to solve longest palindrome question:
     * main idea: we use memo to store the longest length of the string which centered at index id
     * id means the current center which can have the longest palindrome for now
     * mx means the right most of the longest palindrome which centered at id
     * i means the the index we want to compute memo[i]
     * memo[2 * id - i] which means the longest length of the palindrome which centered at the mirror of the i (based of id)
     * There are 2 outer case:
     * 1. i >= mx:
     * ------the memo is useless, then we have to compute the memo by hand ( centered at i , spread out by both left side and right side)
     * 2. i < mx:
     * ------the memo can help us! there are there inner cases here:
     * ------1: memo[2 * id - i] < mx - i:
     * ----------memo[i] = memo[2 * id - i] , doesn't need further computation
     * ----------simple mirror question
     * ------2: memo[2 * id - i] > mx - i:
     * ----------memo[i] = mx - i, doesn't need further computation
     * ----------because we have the center id ,
     * ----------and the left most of the longest palindrome centered at the mirror of i is lefter than the mirror of mx,
     * ----------we assume that @1 the longest palindrome which centered at i can be longer,
     * ----------but the mx is the right most of the longest palindrome which centered at id,
     * ----------since @1 can be longer then the mx can be righter. contradiction! which means rightmost of the longest palindrome
     * ----------which centered at i can't be righter than mx.
     * ------3: memo[2 * id - i] = mx - i:
     * ----------actually, in this case we can say that memo[i] at least equals mx - i. And we need further computation
     * ----------Because, the outer left of the leftmost of the longest palindrome( centered at id) must be different from the outer right of the rightmost of the longest palindrome( centered at id)
     * ----------but the outer right can be the same as the outer left of the longest palindrome ( centered at i)
     * After we have the memo[i], we try to update id and mx to a bigger value. This is because we can benefit from the longer palindrome( save computations)
     * And we update the return relative values( maxI and longestLength)
     * @Params: [s]
     * @Create: 2019/12/2 17:03
     * @Return: java.lang.String
     */
    public String longestPalindromeManacher(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String newString = createFormattedString(s);
        int newLength = newString.length();
        int[] memo = new int[newLength];
        int mx = 0;
        int id = 0;
        int maxI = 0;
        int longestLength = 1;
        boolean needCompute;
        for (int i = 0; i < newLength; i++) {
            if (i < mx) {
                if (memo[2 * id - i] < mx - i) {
                    memo[i] = memo[2 * id - i];
                    needCompute = false;
                } else if (memo[2 * id - i] > mx - i) {
                    memo[i] = mx - i;
                    needCompute = false;
                } else {
                    memo[i] = mx - i;
                    needCompute = true;
                }
            } else {
                memo[i] = 1;
                needCompute = true;
            }
            if (needCompute) {
                while (memo[i] + i < newLength && i - memo[i] >= 0 && newString.charAt(i + memo[i]) == newString.charAt(i - memo[i])) {
                    memo[i]++;
                }
            }
            if (i + memo[i] > mx) {
                id = i;
                mx = i + memo[i];
                //debug
                System.out.println("updating mx to " + mx + " and id to " + id);
            }
            if (memo[i] > longestLength) {
                maxI = i;
                longestLength = memo[i];
            }
            //debug
            System.out.println("-----------");
            for (int j : memo) {
                System.out.print(j);
                System.out.print(' ');
            }
            System.out.println("-----------");
            for (int k = 0; k < newLength; k++) {
                System.out.print(newString.charAt(k));
                System.out.print(' ');
            }
            System.out.println("-----------");
            for (int k = 0; k < newLength; k++) {
                System.out.print(k);
                System.out.print(' ');
            }
            System.out.println("-----------");
        }
        return newString.substring(maxI - longestLength + 1, maxI + longestLength).replace("#", "");
    }

    /**
     * @Description: expand
     * helper function for center spread approach of the longest palindrome question
     * it accepts the string and the left start index and right start index
     * return the length of the longest palindrome with the start indexes.
     * @Params: [s, left, right]
     * @Create: 2019/12/2 22:38
     * @Return: int
     */
    private int expand(String s, int left, int right) {
        int left_index = left;
        int right_index = right;
        // stop condition : the sub string is not palindrome( s.left_index != s.right_index)
        while (left_index >= 0 && right_index < s.length() && s.charAt(left_index) == s.charAt(right_index)) {
            left_index--;
            right_index++;
        }
        return right_index - left_index - 1;
    }

    /**
     * @Description: longestPalindromeCenterSpread
     * single digit expand and double digits expand
     * then find the max and compare with before
     * update start and end index
     * @Params: [s]
     * @Create: 2019/12/2 22:53
     * @Return: java.lang.String
     */
    public String longestPalindromeCenterSpread(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(s, i, i);
            int evenLength = expand(s, i, i + 1);
            int length = Math.max(oddLength, evenLength);
            if (length > end - start) {
                // no matter in odd case or even case, we can get the left shift number by using (length-1)/2 , and get right shift number by using length/2;
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }


}