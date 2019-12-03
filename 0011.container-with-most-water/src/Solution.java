/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
class Solution {
    /**
     * @Description: maxArea
     * we have current for save the current rectangle's water
     * we have toReturn for saving the maximum value
     * strategy: move left index na right index to center, see we can have a better solution or not.
     * Cause
     * @Params: [height]
     * @Create: 2019/12/3 15:37
     * @Return: int
     */
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int left = 0;
        int right = height.length - 1;
        int current = right * Math.min(height[left], height[right]);
        int toReturn = current;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            current = (right - left) * Math.min(height[left], height[right]);
            if (current > toReturn) {
                toReturn = current;
            }
        }
        return toReturn;
    }
}