import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(toReturn, tempList, nums);
        return toReturn;
    }

    private void backtrack(List<List<Integer>> toReturn, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            toReturn.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(toReturn, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}