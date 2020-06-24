/**
 * @ClassName: Leetcode->Solution
 * @Description:
 * @Author: Mingqing Hou
 * @Create: 2020-06-24 11:06
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
 * <p>
 * Initially the number of elements in A and B are m and n respectively.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int lengthA = m - 1;
        int lengthB = n - 1;
        int tail = m + n - 1;
        while (lengthA >= 0 || lengthB >= 0) {
            if (lengthA == -1) {
                A[tail] = B[lengthB--];
            } else if (lengthB == -1) {
                A[tail] = A[lengthA--];
            } else if (A[lengthA] >= B[lengthB]) {
                A[tail] = A[lengthA--];
            } else {
                A[tail] = B[lengthB--];
            }
            tail--;
        }
    }

}
