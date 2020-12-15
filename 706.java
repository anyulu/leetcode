class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {
    Node[] nodes;
    int count;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[16];
        count = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        count++;
        int h = hash(key);
        boolean exist = false;
        Node temp = nodes[h];
        if (temp == null) {
            nodes[h] = new Node(key, value);
            if (count >= nodes.length*0.75) resize();
            return;
        }
        while (true) {
            if (temp.key != key) {
                if (temp.next == null) break;
                temp = temp.next;
            }
            else {
                temp.val = value;
                exist = true;
                break;
            }
        }
        if (!exist) temp.next = new Node(key, value);
        if (count >= nodes.length*0.75) resize();
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Node temp = nodes[h];
        while (temp != null) {
            if (temp.key == key) return temp.val;
            temp = temp.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        count--;
        int h = hash(key);
        Node curr = nodes[h];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    nodes[h] = curr.next;
                    return;
                }
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private void resize() {
        int n = nodes.length*2;
        Node[] newOne = new Node[n];
        for (Node curr: nodes) {
            while (curr != null) {
                int h = (n-1) & curr.key;
                Node temp = newOne[h];
                if (temp == null) {
                    newOne[h] = new Node(curr.key, curr.val);
                    curr = curr.next;
                    continue;
                }
                while (temp.next != null) temp = temp.next;
                temp.next = new Node(curr.key, curr.val);
                curr = curr.next;
            }
        }
        nodes = newOne;
    }

    private int hash(int n) {
        return n & (nodes.length-1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */