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
    boolean exist = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        int currSum = 0;
        dfs(root, sum, currSum);
        return exist;
    }

    public void dfs(TreeNode root, int sum, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == sum) exist = true;
            return;
        }
        if (root.left != null) dfs(root.left, sum, currSum);
        if (root.right != null) dfs(root.right, sum, currSum);
    }
}