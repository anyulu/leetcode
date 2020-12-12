/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return left(root.left, root.val) && right(root.right, root.val);
    }

    private boolean left(TreeNode root, int n) {
        if (root == null) return true;
        int val = root.val;
        if (val >= n) return false;
        boolean left = left(root.left, val);
        if (!left) return false;
        boolean right = right(root.right, val) && left(root.right, n);
        return right;
    }

    private boolean right(TreeNode root, int n) {
        if (root == null) return true;
        int val = root.val;
        if (val <= n) return false;
        boolean right = right(root.right, val);
        if (!right) return false;
        boolean left = left(root.left, val) && right(root.left, n);
        return left;
    }
}