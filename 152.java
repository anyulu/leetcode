class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]), nums[i]);
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}