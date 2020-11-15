class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length+2][nums.length+2];
        int[] val = new int[nums.length+2];
        System.arraycopy(nums, 0, val, 1, nums.length);
        val[0] = val[nums.length+1] = 1;
        return helper(dp, val, 0, nums.length+1);
    }

    private int helper(int[][] dp, int[] val, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int res = 0;
        for (int k = i+1; k < j; k++) {
            res = Math.max(res, val[i]*val[j]*val[k]+helper(dp,val,i,k)+helper(dp,val,k,j));
        }
        dp[i][j] = res;
        return res;
    }
}

// TLE
class Solution {
    Map<int[], Integer> map;

    public int maxCoins(int[] nums) {
        map = new HashMap<>();
        return dp(nums);
    }

    private int dp(int[] nums) {
        if (map.containsKey(nums)) return map.get(nums);
        if (nums.length == 1) return nums[0];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[nums.length-1];
            System.arraycopy(nums, 0, next, 0, i);
            System.arraycopy(nums, i+1, next, i, nums.length-1-i);
            int left = i == 0 ? 1 : nums[i-1];
            int right = i == nums.length-1 ? 1 : nums[i+1];
            res = Math.max(res, left*nums[i]*right + dp(next));
        }
        map.put(nums, res);
        return res;
    }
}