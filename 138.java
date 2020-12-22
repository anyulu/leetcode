/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (map.containsKey(head)) return map.get(head);
        Node res = new Node(head.val);
        map.put(head, res);
        res.next = copyRandomList(head.next);
        res.random = copyRandomList(head.random);
        return res;
    }
}