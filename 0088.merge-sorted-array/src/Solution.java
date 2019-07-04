public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int current = nums1.length - 1;
        while (current >= 0) {
            if (n == 0) {
                return;
            }
            if (m <= 0) {
                nums1[current--] = nums2[--n];
                continue;
            }
            if (n <= 0) {
                nums1[current--] = nums1[--m];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[current--] = nums1[--m];
            } else {
                nums1[current--] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        new Solution().merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
