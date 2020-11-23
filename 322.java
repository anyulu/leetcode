class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        for (int j = 1; j <= amount; j++) {
            if (coins[0] <= j && dp[0][j-coins[0]] != -1)
                dp[0][j] = 1+dp[0][j-coins[0]];
            else dp[0][j] = -1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j && dp[i][j-coins[i]] != -1)
                    dp[i][j] = 1+dp[i][j-coins[i]];
                else dp[i][j] = dp[i-1][j];
                if (dp[i-1][j] != -1) dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
            }
        }
        return dp[coins.length-1][amount];
    }
}