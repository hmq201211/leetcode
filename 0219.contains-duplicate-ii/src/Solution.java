import java.util.TreeSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeSet.contains(nums[i])) {
                return true;
            }
            treeSet.add(nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}