class Solution {
    int[] parent;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int count = 0;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions.length == 0) return res;
        int size = m*n;
        parent = new int[size];
        boolean[][] visit = new boolean[m][n];
        for (int i = 1; i < size; i++) {
            parent[i] = i;
        }

        for (int[] pos: positions) {
            int x = pos[0];
            int y = pos[1];
            if (visit[x][y]) {
                res.add(count);
                continue;
            }
            visit[x][y] = true;
            count++;
            for (int[] dir: dirs) {
                int xx = x+dir[0];
                int yy = y+dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || !visit[xx][yy]) continue;
                union(x*n+y, xx*n+yy);
            }

            res.add(count);
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
        if (px == py) return;
        parent[py] = px;
        count--;
    }
}