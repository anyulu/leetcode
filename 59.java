class Solution {
    public int[][] generateMatrix(int n) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][n];
        res[0][0] = 1;
        int count = 1;
        int d = 0;
        int x = 0, y = 0;
        while (count++ < n*n) {
            if (x+dirs[d][0] < 0 || x+dirs[d][0] == n ||
                y+dirs[d][1] < 0 || y+dirs[d][1] == n ||
                res[x+dirs[d][0]][y+dirs[d][1]] != 0) {
                d = (d+1) % 4;
            }
            x += dirs[d][0];
            y += dirs[d][1];
            res[x][y] = count;
        }
        return res;
    }
}