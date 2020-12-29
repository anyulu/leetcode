class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int x = 0, y = 0;
        int m = grid.length;
        int n = grid[0].length();
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c >= 'a' && c <= 'f') {
                    k += 1 << (c-'a');
                }
                if (c == '@') {
                    x = i;
                    y = j;
                }
            }
        }
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        boolean[][][] visit = new boolean[m][n][64];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        visit[x][y][0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] dir: dirs) {
                    int xx = curr[0]+dir[0];
                    int yy = curr[1]+dir[1];
                    int newKey = curr[2];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n ||
                        visit[xx][yy][newKey] || grid[xx].charAt(yy) == '#') {
                        continue;
                    }
                    char c = grid[xx].charAt(yy);
                    if (c >= 'a' && c <= 'f') {
                        int i = c-'a';
                        if (!hasKey(newKey, i)) {
                            newKey += (1 << i);
                            if (newKey == k) return step;
                        }
                    } else if (c >= 'A' && c <= 'F') {
                        int i = c-'A';
                        if (!hasKey(newKey, i)) continue;
                    }
                    visit[xx][yy][newKey] = true;
                    queue.offer(new int[]{xx, yy, newKey});
                }
            }
        }
        return -1;
    }

    private boolean hasKey(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}