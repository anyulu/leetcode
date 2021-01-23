class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int curr = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
            prev = nums[i];
        }
        return res;
    }
}