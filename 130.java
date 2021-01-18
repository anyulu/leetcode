class Solution {
    boolean[][] visit;
    int m;
    int n;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'V' ? 'O' : 'X';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (visit[x][y] || board[x][y] != 'O') return;
        visit[x][y] = true;
        board[x][y] = 'V';

        for (int[] dir: dirs) {
            int xx = x+dir[0];
            int yy = y+dir[1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
            dfs(board, xx, yy);
        }
    }
}