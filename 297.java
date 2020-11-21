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
        if (root == null) return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                res.append("#,");
            } else {
                res.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode res = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(res);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode root = queue.poll();
            if (!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                root.left = left;
                queue.add(left);
            }
            i++;
            if (!nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                root.right = right;
                queue.add(right);
            }
            i++;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));