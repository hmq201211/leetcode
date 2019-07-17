class Solution {
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int head = 0;
        int tail = height.length - 1;
        int toReturn = 0;
        int temp = 0;
        while (tail > head) {
            if (height[head] < height[tail]) {
                temp = (tail - head) * height[head];
                head++;
            } else {
                temp = (tail - head) * height[tail];
                tail--;
            }
            if (temp > toReturn) {
                toReturn = temp;
            }
        }
        return toReturn;
    }
}