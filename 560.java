class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1]+nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == k) count++;
            for (int j = i-1; j >= 0; j--) {
                if (sum[i]-sum[j] == k) count++;
            }
        }
        return count;
    }
}

// TLE
class Solution {
    int count = 0;

    public int subarraySum(int[] nums, int k) {
        dfs(nums, k, 0, false, 0);
        return count;
    }

    private void dfs(int[] nums, int sum, int index, boolean next, int num) {
        if (index == nums.length) return;

        if (!next) {
            if (sum == 0 && num != 0) count++;
            dfs(nums, sum, index+1, false, num);
        }
        if (sum == nums[index]) count++;
        dfs(nums, sum-nums[index], index+1, true, num+1);
    }
}