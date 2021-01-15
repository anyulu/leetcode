class Solution {
    int m;
    int n;
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int[] parent;
    int[] count;
    int size;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int l = hits.length;
        m = grid.length;
        n = grid[0].length;
        size = m*n;
        parent = new int[size+1];
        count = new int[size+1];
        int[] res = new int[l];
        int[][] temp = new int[m][n];

        Arrays.fill(count, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                parent[i*n+j] = i*n+j;
                temp[i][j] = grid[i][j];
            }
        }
        parent[size] = size;

        for (int[] hit: hits) {
            temp[hit[0]][hit[1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (temp[0][i] == 1) union(i, size);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) continue;
                for (int[] dir: dirs) {
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || temp[x][y] == 0) continue;
                    union(i*n+j, x*n+y);
                }
            }
        }

        for (int i = l-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) continue;
            int prev = count[size];
            if (x == 0) union(y, size);
            for (int[] dir: dirs) {
                int xx = x+dir[0];
                int yy = y+dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || temp[xx][yy] == 0) continue;
                union(x*n+y, xx*n+yy);
            }
            res[i] = Math.max(0, count[size]-prev-1);
            temp[x][y] = 1;
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
        if (px < py) {
            parent[px] = py;
            count[py] += count[px];
        } else if (px > py) {
            parent[py] = px;
            count[px] += count[py];
        }
    }
}