class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) &&
                    dfs(board, word, i, j, new boolean[m][n], 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] visit, int index) {
        if (visit[x][y]) return false;
        if (index == word.length()-1) return true;

        char actual = word.charAt(index);
        if (actual != board[x][y]) return false;
        visit[x][y] = true;
        if (x > 0 && board[x-1][y] == word.charAt(index+1)) {
            if (dfs(board, word, x-1, y, visit, index+1)) return true;
        }
        if (x < board.length-1 && board[x+1][y] == word.charAt(index+1)) {
            if (dfs(board, word, x+1, y, visit, index+1)) return true;
        }
        if (y > 0 && board[x][y-1] == word.charAt(index+1)) {
            if (dfs(board, word, x, y-1, visit, index+1)) return true;
        }
        if (y < board[0].length-1 && board[x][y+1] == word.charAt(index+1)) {
            if (dfs(board, word, x, y+1, visit, index+1)) return true;
        }
        visit[x][y] = false;
        return false;
    }
}