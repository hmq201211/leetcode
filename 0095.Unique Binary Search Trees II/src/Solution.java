
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {

        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int length = 1; length <= n; length++) {
            dp[length] = new ArrayList<>();
            for (int root = 1; root <= length; root++) {
                int left = root - 1;
                int right = length - root;
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        treeRoot.right = clone(rightTree, root);
                        dp[length].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode treeNode, int offset) {
        if (treeNode == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(treeNode.val + offset);
        newNode.left = clone(treeNode.left, offset);
        newNode.right = clone(treeNode.right, offset);
        return newNode;
    }
}