class Solution {
    public int findDerangement(int n) {
        if (n == 0 || n == 1) return 0;
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (int)((i-1L)*(dp[i-1]+dp[i-2]) % (int) (Math.pow(10,9)+7));
        }
        return dp[n];
    }
}