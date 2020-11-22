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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        else if (n == 1) return new TreeNode(preorder[0]);
        TreeNode res = new TreeNode(preorder[0]);
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        int len1 = index;
        int len2 = n-1-index;
        res.left = buildTree(Arrays.copyOfRange(preorder, 1, len1+1),
            Arrays.copyOfRange(inorder, 0, index));
        res.right = buildTree(Arrays.copyOfRange(preorder, len1+1, n),
            Arrays.copyOfRange(inorder, index+1, n));
        return res;
    }
}