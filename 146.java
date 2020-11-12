class LRUCache {

    Stack<Integer> stack;
    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        stack = new Stack<>();
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            stack.remove((Integer) key);
            stack.push(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (stack.contains(key)) {
            stack.remove((Integer)key);
        } else if (stack.size() == capacity) {
            int temp = stack.get(0);
            stack.remove((Integer) temp);
            map.remove(temp);
        }
        stack.push(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */