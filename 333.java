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
class Result {
    int max;
    int min;
    int count;

    public Result(int max, int min, int count) {
        this.max = max;
        this.min = min;
        this.count = count;
    }
}

class Solution {
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).count;
    }

    private Result dfs(TreeNode root) {
        if (root == null) return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (root.val > left.max && root.val < right.min) {
            return new Result(Math.max(right.max, root.val), Math.min(left.min, root.val), left.count+right.count+1);
        }
        return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.count, right.count));
    }
}