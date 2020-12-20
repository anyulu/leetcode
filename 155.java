class Node {
    int val;
    int min;
    Node prev;

    public Node(int val, int min, Node prev) {
        this.val = val;
        this.min = min;
        this.prev = prev;
    }
}

class MinStack {
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
        Node head = null;
    }

    public void push(int x) {
        if (head == null) head = new Node(x, x, null);
        else {
            Node temp = new Node(x, Math.min(head.min, x), head);
            head = temp;
        }
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */