import java.util.HashMap;

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

class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return helper(root, 0, sum, hashMap);
    }

    private int helper(TreeNode treeNode, int accumulate, int sum, HashMap<Integer, Integer> hashMap) {
        if (treeNode == null) {
            return 0;
        }
        int count = 0;
        accumulate += treeNode.val;
        if (accumulate == sum) {
            count++;
        }
        if (hashMap.containsKey(accumulate - sum)) {
            count += hashMap.get(accumulate - sum);
        }
        if (!hashMap.containsKey(accumulate)) {
            hashMap.put(accumulate, 1);
        } else {
            hashMap.put(accumulate, hashMap.get(accumulate) + 1);
        }
        int toReturn = count + helper(treeNode.left, accumulate, sum, hashMap) + helper(treeNode.right, accumulate, sum, hashMap);
        hashMap.put(accumulate, hashMap.get(accumulate) - 1);
        return toReturn;
    }
}



