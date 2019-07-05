import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        return iterativeSolution(root);
    }

    private int recursiveSolution(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(recursiveSolution(root.left), recursiveSolution(root.right));
    }

    private int iterativeSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode temp;
        int depth = 1;
        while (queue.size() != 0) {
            temp = queue.poll();
            if (temp == null) {
                if (queue.size() == 0) {
                    return depth;
                }
                depth++;
                queue.offer(null);
                continue;
            }
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return depth;


    }

    public static void main(String[] args) {

    }

}