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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        for (Integer i: inorderTraversal(root.left)) {
            res.add(i);
        }
        res.add(root.val);
        for (Integer i: inorderTraversal(root.right)) {
            res.add(i);
        }
        return res;
    }
}