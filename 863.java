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
    Map<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    map.put(tempNode.left, tempNode);
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    map.put(tempNode.right, tempNode);
                    queue.offer(tempNode.right);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        dfs(target, res, K, new HashSet<>());
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int K, Set<TreeNode> visit) {
        if (root == null || visit.contains(root)) return;
        visit.add(root);
        if (K == 0) {
            res.add(root.val);
            return;
        }

        dfs(root.left, res, K-1, visit);
        dfs(root.right, res, K-1, visit);
        dfs(map.get(root), res, K-1, visit);
    }
}