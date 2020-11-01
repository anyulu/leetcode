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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int num = queue.size();
            List<Integer> traversal = new ArrayList<>();
            while (num > 0) {
                TreeNode currRoot = queue.poll();
                traversal.add(currRoot.val);
                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
                num--;
            }
            result.add(traversal);
        }
        return result;
    }
}