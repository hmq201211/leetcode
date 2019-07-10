import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] toReturn = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums1) {
            hashMap.put(num, num);
        }
        for (int num : nums2) {
            if (hashMap.containsKey(num)) {
                toReturn[index++] = num;
                hashMap.remove(num);
            }
        }
        return Arrays.copyOf(toReturn, index);
    }
}