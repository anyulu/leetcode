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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) return result;
        return generate(1,n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = new ArrayList<>(generate(start, i-1));
            List<TreeNode> right = new ArrayList<>(generate(i+1, end));
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    result.add(temp);
                }
            }
        }
        return result;
    }
}