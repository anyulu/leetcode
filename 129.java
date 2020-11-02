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
    static int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}