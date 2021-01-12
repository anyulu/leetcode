class Solution {
    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        int[] degree = new int[n+1];
        for (int[] edge: edges) {
            degree[edge[1]]++;
        }

        for (int i = n-1; i >= 0; i--) {
            if (degree[edges[i][1]] == 2) {
                if (!isCircle(edges, i)) return edges[i];
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if (degree[edges[i][1]] == 1) {
                if (!isCircle(edges, i)) return edges[i];
            }
        }
        return new int[]{-1,-1};
    }

    private boolean isCircle(int[][] edges, int index) {
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == index) continue;
            int in = edges[i][0];
            int out = edges[i][1];
            if (find(in) == find(out)) return true;
            union(in, out);
        }
        return false;
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