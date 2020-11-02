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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, new String());
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String s){
        if (root == null) return;
        s += root.val + "->";
        if (root.left == null && root.right == null) {
            s  = s.substring(0, s.length()-2);
            res.add(new String(s));
            return;
        }
        if (root.left != null) dfs(root.left, res, s);
        if (root.right != null) dfs(root.right, res, s);
    }
}