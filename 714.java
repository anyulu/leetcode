class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        int max = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], prices[i]+dp[i-1][1]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}