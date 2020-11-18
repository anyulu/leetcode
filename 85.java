class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else if (matrix[i][j] == '1') dp[i][j] = 1+dp[i][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                int prev = i;
                int temp = dp[i][j];
                while (prev >= 0) {
                    if (dp[prev][j] != 0) {
                        temp = Math.min(dp[prev][j], temp);
                        max = Math.max(max, temp*(i-prev+1));
                        prev--;
                    } else break;
                }
            }
        }
        return max;
    }
}

// MLE
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        boolean[][][][] dp = new boolean[m][n][m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j][i][j] = true;
                    max = 1;
                }
            }
        }
        for (int l = 0; l < m; l++) {
            for (int i = 0; i < n; i++) {
                if (matrix[l][i] == '0') continue;
                for (int j = i-1; j >= 0; j--) {
                    if (matrix[l][j] == '0') continue;
                    dp[l][j][l][i] = dp[l][j+1][l][i];
                    if (dp[l][j][l][i]) max = Math.max(max, i-j+1);
                }
            }
        }
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][l] == '0') continue;
                for (int j = i-1; j >= 0; j--) {
                    if (matrix[j][l] == '0') continue;
                    dp[j][l][i][l] = dp[j+1][l][i][l];
                    if (dp[j][l][i][l]) max = Math.max(max, i-j+1);
                }
            }
        }
        for (int y2 = 1; y2 < m; y2++) {
            for (int x2 = 1; x2 < n; x2++) {
                if (matrix[y2][x2] == '0') continue;
                for (int y1 = y2-1; y1 >= 0; y1--) {
                    for (int x1 = x2-1; x1 >= 0; x1--) {
                        if (matrix[y1][x1] == '0') continue;
                        dp[y1][x1][y2][x2] = dp[y1+1][x1][y2][x2] && dp[y1][x1+1][y2][x2];
                        if (dp[y1][x1][y2][x2]) max = Math.max(max, (x2-x1+1)*(y2-y1+1));
                    }
                }
            }
        }

        return max;
    }
}