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
    public int pathSum(TreeNode root, int sum) {
        boolean next = false;
        return dfs(root, sum, 0, next);
    }

    private static int dfs(TreeNode root, int S, int count, boolean next) {
        if (root == null) return count;
        if (root.val == S) count++;
        if (root.left == null && root.right == null) return count;
        if (next) {
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        } else {
            count = dfs(root.left, S, count, false);
            count = dfs(root.right, S, count, false);
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        }
        return count;
    }
}