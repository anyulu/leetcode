class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+nums[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}