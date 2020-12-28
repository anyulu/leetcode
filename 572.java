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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (isSubtree(s.left, t) || isSubtree(s.right, t)) return true;
        if (s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null || s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}