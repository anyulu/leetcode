class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) A[i][j] = 1-A[i][j];
            }
        }
        int res = 0;
        res += m * (1 << (n-1));
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 1) count++;
            }
            count = Math.max(count, m-count);
            res += count * (1 << (n-1-i));
        }
        return res;
    }
}