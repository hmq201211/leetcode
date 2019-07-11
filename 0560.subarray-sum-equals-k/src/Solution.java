import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int accumulate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            accumulate += temp;
            if (accumulate == k) {
                count++;
            }
            if (hashMap.containsKey(accumulate - k)) {
                count += hashMap.get(accumulate - k);
            }
            if (!hashMap.containsKey(accumulate)) {
                hashMap.put(accumulate, 1);
            } else {
                hashMap.put(accumulate, hashMap.get(accumulate) + 1);
            }
        }
        return count;
    }
}