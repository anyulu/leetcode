class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = dp[1] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) dp[1] = Math.max(dp[1], 1+dp[0]);
            else if (nums[i] < nums[i-1]) dp[0] = Math.max(dp[0], 1+dp[1]);
            max = Math.max(Math.max(dp[1], dp[0]), max);
        }
        return max;
    }
}