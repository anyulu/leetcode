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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return max-1;
    }

    private int dfs(TreeNode root, int len) {
        if (root == null) return len;
        int left = dfs(root.left, len);
        int right = dfs(root.right, len);
        if (left + right + 1 > max) max = left+right+1;
        return 1+Math.max(left, right);
    }
}