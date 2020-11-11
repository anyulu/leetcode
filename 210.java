class Solution {
    public int[] findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tasks; i++) {
            map.put(i, 0);
            requireMap.put(i, new ArrayList<Integer>());
        }
        for (int[] line: prerequisites) {
            map.put(line[0], map.get(line[0])+1);
            requireMap.get(line[1]).add(line[0]);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        while (!queue.isEmpty()) {
            int root = queue.poll();
            sortedOrder.add(root);
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        if (sortedOrder.size() != tasks) return new int[0];
        return sortedOrder.stream().mapToInt(i -> i).toArray();
    }
}