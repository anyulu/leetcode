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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode temp = helper(root.left);
            if (temp.right == null) {
                temp.right = root.right;
                return temp;
            }
            TreeNode res = temp.right;
            res.right = root.right;
            temp.right = res.left;
            res.left = root.left;
            return res;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        while (root.right != null && root.right.right != null) {
            root = root.right;
        }
        return root;
    }
}