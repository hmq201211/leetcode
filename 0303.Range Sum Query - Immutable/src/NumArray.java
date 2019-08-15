class NumArray {
    private int[] sumArray;

    public NumArray(int[] nums) {
        this.sumArray = new int[nums.length + 1];
        int sum = 0;
        sumArray[0] = 0;
        int index = 1;
        for (int num : nums) {
            sum += num;
            sumArray[index++] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return this.sumArray[j + 1] - sumArray[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */