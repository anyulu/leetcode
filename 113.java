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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int currSum = 0;
        dfs(res, root, sum, path, currSum);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int sum, List<Integer> path, int currSum) {
        if (root == null) return;
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) {
                res.add(new ArrayList<Integer>(path));
                System.out.print(path);
            }
            return;
        }
        if (root.left != null) {
            dfs(res, root.left, sum, path, currSum);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            dfs(res, root.right, sum, path, currSum);
            path.remove(path.size()-1);
        }
    }
}


// second
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
    List<Integer> path = new ArrayList<>();
    int currSum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int sum) {
        if (root == null) return;
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) {
                res.add(new ArrayList<Integer>(path));
                System.out.print(path);
            }
            return;
        }
        if (root.left != null) {
            dfs(res, root.left, sum);
            path.remove(path.size()-1);
            currSum -= root.left.val;
        }
        if (root.right != null) {
            dfs(res, root.right, sum);
            path.remove(path.size()-1);
            currSum -= root.right.val;
        }
    }
}