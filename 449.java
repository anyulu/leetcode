/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        res.append(root.val + " ");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] strings = data.split(" ");
        int n = strings.length;
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = Integer.parseInt(strings[i]);
        }
        return helper(vals, 0, n-1);
    }

    private TreeNode helper(int[] arr, int left, int right) {
        if (left == -1 || right < left) return null;
        if (left == right) return new TreeNode(arr[left]);
        int n = arr.length;
        TreeNode root = new TreeNode(arr[left]);
        int x = -1, y = left+1;
        if (arr[left] > arr[left+1]) {
            x = left+1;
            while (y <= right) {
                if (arr[y] < arr[left]) y++;
                else break;
            }
        }
        root.left = helper(arr, x, y-1);
        root.right = helper(arr, y, right);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;