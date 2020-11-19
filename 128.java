class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] == 1) {
                dp[i] = dp[i-1]+1;
                max = Math.max(max, dp[i]);
            } else if (nums[i] == nums[i-1]) dp[i] = dp[i-1];
            else dp[i] = 1;
        }
        return max;
    }
}