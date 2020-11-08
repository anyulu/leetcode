class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> curr: map.entrySet()) {
            queue.add(curr);
            if (queue.size() > k) queue.poll();
        }
        while (queue.size() > 0) {
            topNumbers.add(queue.poll().getKey());
        }
        return topNumbers.stream().mapToInt(i->i).toArray();
    }
}