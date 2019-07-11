
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int self = worker(root, sum);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return self + left + right;

    }

    private int worker(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int left = worker(root.left, sum - root.val);
        int right = worker(root.right, sum - root.val);
        return left + right + (root.val == sum ? 1 : 0);
    }
}