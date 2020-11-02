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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return arr.length == 0;
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode root, int[] sequence, int index) {
        if (root == null) return false;
        if (index >= sequence.length || root.val != sequence[index]) return false;
        if (root.left == null && root.right == null) {
            if (index == sequence.length-1) return true;
            return false;
        }
        return dfs(root.left, sequence, index+1) || dfs(root.right, sequence, index+1);
    }
}