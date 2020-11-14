class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) dp[i] = i;
        for (int i = 2; i <= m; i++) {
            int sqr = i*i;
            for (int j = n; j >= 0; j--) {
                int count = 1;
                int index = j;
                while (index >= sqr) {
                    index -= sqr;
                    dp[j] = Math.min(dp[j], dp[index]+count);
                    count++;
                }
            }
        }
        return dp[n];
    }
}