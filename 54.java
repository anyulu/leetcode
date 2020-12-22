class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        int count = m*n-1;
        res.add(matrix[x][y]);
        visit[x][y] = true;
        while (count-- > 0) {
            if (x+dirs[dir][0] >= 0 && x+dirs[dir][0] < m &&
                y+dirs[dir][1] >= 0 && y+dirs[dir][1] < n) {
                if (visit[x+dirs[dir][0]][y+dirs[dir][1]]) dir = (dir+1)%4;
            } else dir = (dir+1) % 4;
            x += dirs[dir][0];
            y += dirs[dir][1];
            res.add(matrix[x][y]);
            visit[x][y] = true;
        }
        return res;
    }
}