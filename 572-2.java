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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sS = dfs(s);
        String tS = dfs(t);
        return kmp(sS, tS);
    }

    private String dfs(TreeNode root) {
        if (root == null) return " ";
        return "#" + root.val + dfs(root.left) + dfs(root.right);
    }

    private boolean kmp(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] f = new int[n];
        f[0] = -1;
        for (int i = 1, j = -1; i < n; i++) {
            while (j != -1 && t.charAt(i) != t.charAt(j+1)) {
                j = f[j];
            }
            if (t.charAt(i) != t.charAt(j+1)) {
                f[i] = -1;
            } else {
                f[i] = ++j;
            }
        }

        for (int i = 0, j = -1; i < m; i++) {
            while (j != -1 && s.charAt(i) != t.charAt(j+1)) {
                j = f[j];
            }
            if (s.charAt(i) == t.charAt(j+1)) {
                j++;
            }
            if (j == n-1) return true;
        }
        return false;
    }
}