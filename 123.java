class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] hold = new int[n][3];
        int[][] empty = new int[n][3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            hold[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            hold[i][1] = Math.max(hold[i-1][1], empty[i-1][0]-prices[i]);
            empty[i][1] = Math.max(empty[i-1][1], hold[i-1][1]+prices[i]);
            max = Math.max(max, empty[i][1]);
            hold[i][2] = Math.max(hold[i-1][2], empty[i-1][1]-prices[i]);
            empty[i][2] = Math.max(empty[i-1][2], hold[i-1][2]+prices[i]);
            max = Math.max(max, empty[i][2]);
        }
        return max;
    }
}