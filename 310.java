class Solution {
    public List<Integer> findMinHeightTrees(int nodes, int[][] edges) {
        if (nodes == 1) return new ArrayList<>(Arrays.asList(0));
        List<Integer> minHeightTrees = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (degree[i] == 1) queue.add(i);
        }
        while (!queue.isEmpty()) {
            minHeightTrees = new ArrayList<>();
            int n = queue.size();
            while (n > 0) {
                int root = queue.poll();
                minHeightTrees.add(root);
                n--;
                for (int leaf: map.get(root)) {
                    degree[leaf]--;
                    if (degree[leaf] == 1) queue.add(leaf);
                }
            }
        }
        return minHeightTrees;
    }
}


// TLE, need to optimize
class Solution {
    public List<Integer> findMinHeightTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes; i++) map.put(i, new ArrayList<Integer>());
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[] dp = new int[nodes];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes; i++) {
            dp[i] = dfs(map,new boolean[nodes], i);
            min = Math.min(min, dp[i]);
        }
        for (int i = 0; i < nodes; i++) {
            if (dp[i] == min) minHeightTrees.add(i);
        }

        return minHeightTrees;
    }

    private int dfs(Map<Integer, List<Integer>> map,boolean[] visit, int node) {
        visit[node] = true;
        int res = -1;
        for (int i: map.get(node)) {
            if (visit[i]) continue;
            visit[i] = true;
            res = Math.max(res, 1+dfs(map, visit, i));
        }
        return res == -1 ? 1 : res;
    }
}