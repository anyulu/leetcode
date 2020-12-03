class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int n: nums) {
            if (map.containsKey(n-1)) {
                int len = map.get(n-1).poll();
                map.computeIfAbsent(n, k -> new PriorityQueue<Integer>()).add(len+1);
                if (map.get(n-1).isEmpty()) map.remove(n-1);
            } else {
                map.computeIfAbsent(n, k -> new PriorityQueue<Integer>()).add(1);
            }
        }
        for (PriorityQueue<Integer> queue: map.values()) {
            if (queue.peek() < 3) return false;
        }
        return true;
    }
}