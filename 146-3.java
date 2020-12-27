class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int cap;
    int size;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.cap = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        move(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            size++;
            Node temp = new Node(key, value);
            addHead(temp);
            map.put(key, temp);
        } else {
            Node node = map.get(key);
            node.val = value;
            move(node);
        }
        if (size > cap) {
            map.remove(tail.prev.key);
            delete(tail.prev);
            size--;
        }
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void move(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addHead(node);
    }

    private void delete(Node node) {
        Node temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */