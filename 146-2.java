class Node {
    int key, value;
    Node next, prev;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            moveToHead(map.get(key));
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Node removeNode = removeTail();
                map.remove(removeNode.key);
                size--;
            }
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }


    private Node removeTail() {
        Node res = tail.prev;
        res.prev.next = tail;
        tail.prev = res.prev;
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */