class Solution {
    int[] parent;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        parent = new int[4*n*n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                int index = 4*(i*n+j);
                if (c == ' ') {
                    union(index, index+1);
                    union(index+1, index+2);
                    union(index+2, index+3);
                } else if (c == '/') {
                    union(index, index+3);
                    union(index+1, index+2);
                } else if (c == '\\') {
                    union(index, index+1);
                    union(index+2, index+3);
                }
                if (i > 0) {
                    union(index, index-4*n+2);
                }
                if (j > 0) {
                    union(index-3, index+3);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == i) res++;
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
        if (px != py) {
            parent[py] = px;
        }
    }
}