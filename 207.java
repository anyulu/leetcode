class Solution {
    public boolean canFinish(int tasks, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> requireMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tasks; i++) {
            map.put(i, 0);
            requireMap.put(i, new ArrayList<Integer>());
        }
        for (int[] line: prerequisites) {
            map.put(line[1], map.get(line[1])+1);
            requireMap.get(line[0]).add(line[1]);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) queue.add(key);
        }
        while (!queue.isEmpty()) {
            int root = queue.poll();
            tasks--;
            for (int leaf: requireMap.get(root)) {
                map.put(leaf, map.get(leaf)-1);
                if (map.get(leaf) == 0) queue.add(leaf);
            }
        }
        return tasks == 0;
    }
}