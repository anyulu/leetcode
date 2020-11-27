/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2 == null;
        if (t2 == null) return t1 == null;
        if (t1.val != t2.val) return false;
        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}