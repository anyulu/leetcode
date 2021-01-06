class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int m = isConnected.length;
        boolean[] visit = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (visit[i]) continue;
            dfs(isConnected, visit, i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visit, int x) {
        if (visit[x]) return;
        visit[x] = true;
        for (int y = 0; y < isConnected.length; y++) {
            if (isConnected[x][y] == 0) continue;
            dfs(isConnected, visit, y);
        }
    }
}