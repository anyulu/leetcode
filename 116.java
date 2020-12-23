/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node res = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node prev = null;
            while (n-- > 0) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }
        return res;
    }
}