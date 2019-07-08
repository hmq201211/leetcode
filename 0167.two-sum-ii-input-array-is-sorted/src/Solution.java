class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] toRetuen = new int[2];
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                break;
            } else {
                if (numbers[head] + numbers[tail] > target) {
                    tail--;
                }
                if (numbers[head] + numbers[tail] < target) {
                    head++;
                }
            }
        }
        toRetuen[0] = head + 1;
        toRetuen[1] = tail + 1;
        return toRetuen;
    }
}