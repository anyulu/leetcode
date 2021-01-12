class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges) {
            if (find(edge[0]-1) == find(edge[1]-1)) return edge;
            union(edge[0]-1, edge[1]-1);
        }
        return new int[]{-1,-1};
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