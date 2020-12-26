class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0] > 0 ? nums[0] : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] > 0 ? nums[i]+dp[i-1] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}