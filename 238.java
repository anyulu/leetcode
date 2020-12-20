class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = 1; i < n; i++) left[i] = nums[i-1]*left[i-1];
        for (int i = n-2; i >= 0; i--) right[i] = nums[i+1]*right[i+1];
        int[] res = new int[n];
        res[0] = right[0];
        res[n-1] = left[n-1];
        for (int i = 1; i < n-1; i++) res[i] = left[i]*right[i];
        return res;
    }
}