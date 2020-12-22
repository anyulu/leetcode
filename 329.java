class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, new boolean[matrix.length][matrix[0].length], res, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, boolean[][] visit, int[][] res, int x, int y) {
        if (res[x][y] != 0) return res[x][y];

        visit[x][y] = true;
        res[x][y] = 1;
        for (int[] dir: dirs) {
            int i = x+dir[0], j = y+dir[1];
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length
                && matrix[x][y] < matrix[i][j] && !visit[i][j]) {
                res[x][y] = Math.max(res[x][y], 1+dfs(matrix, visit, res, i, j));
            }
        }
        visit[x][y] = false;
        return res[x][y];
    }
}

// improve
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, res, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] res, int x, int y) {
        if (res[x][y] != 0) return res[x][y];

        res[x][y] = 1;
        for (int[] dir: dirs) {
            int i = x+dir[0], j = y+dir[1];
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length
                && matrix[x][y] < matrix[i][j]) {
                res[x][y] = Math.max(res[x][y], 1+dfs(matrix, res, i, j));
            }
        }
        return res[x][y];
    }
}