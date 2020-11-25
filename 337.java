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
    public int rob(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean stop) {
        if (root == null) return 0;

        int left1 = dfs(root.left, false);
        int right1 = dfs(root.right, false);
        if (stop) return left1+right1;
        int left2 = dfs(root.left, true);
        int right2 = dfs(root.right, true);
        return Math.max(left1+right1, root.val+left2+right2);
    }
}