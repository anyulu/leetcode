class Solution {
    int[] parent;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        int res = 0;
        if (connections.length < n-1) return -1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: connections) {
            union(edge[0], edge[1]);
        }
        for (int i = 1; i < n; i++) {
            if (find(i) != find(0)) {
                union(i, 0);
                res++;
            }
        }
        return res;
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parent[py] = px;
    }
}