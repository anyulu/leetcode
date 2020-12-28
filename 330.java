class Solution {
    public int minPatches(int[] nums, int n) {
        long res = 0;
        int index = 0;
        int count = 0;
        while (res < n) {
            if (index >= nums.length || nums[index] > res+1) {
                count++;
                res = res*2+1;
            } else {
                res += nums[index++];
            }
        }
        return count;
    }
}