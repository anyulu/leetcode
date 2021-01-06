class Solution {
    int m, n;
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}, {0,0}};

    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int start = encode(mat);
        if (start == 0) return 0;
        queue.offer(start);
        set.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                for (int ii = 0; ii < m; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        int next = flip(curr, ii, jj);
                        if (next == 0) return res;
                        if (set.contains(next)) continue;
                        set.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int encode(int[][] mat) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = res*2 + mat[i][j];
            }
        }
        return res;
    }

    private int[][] decode(int x) {
        int[][] res = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                res[i][j] = x&1;
                x >>= 1;
            }
        }
        return res;
    }

    private int flip(int num, int x, int y) {
        int[][] temp = decode(num);
        for (int[] dir: dirs) {
            int xx = x+dir[0];
            int yy = y+dir[1];
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                temp[xx][yy] ^= 1;
            }
        }
        return encode(temp);
    }
}