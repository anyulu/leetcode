class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (visit[x][y]) continue;
            visit[x][y] = true;
            count++;
            for (int[] dir: dirs) {
                int xx = x+dir[0];
                int yy = y+dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || visit[xx][yy]) continue;
                if (reachable(xx, yy, k)) queue.add(new int[]{xx,yy});
            }
        }
        return count;
    }

    private boolean reachable(int m, int n, int k) {
        int count = 0;
        while (m > 0) {
            count += m % 10;
            m /= 10;
        }
        while (n > 0) {
            count += n % 10;
            n /= 10;
        }
        return count <= k;
    }
}