class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i][1] = Math.max(dp[i][1], 1+dp[j][0]);
                else if (nums[i] < nums[j]) dp[i][0] = Math.max(dp[i][0], 1+dp[j][1]);
            }
            max = Math.max(Math.max(dp[i][1], dp[i][0]), max);
        }
        return max;
    }
}