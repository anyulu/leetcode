class Solution {
    public int reversePairs(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left+right)/2;
        int res1 = helper(nums, left, mid);
        int res2 = helper(nums, mid+1, right);
        int res = res1+res2;
        int i = left;
        int j = mid+1;
        while (i <= mid) {
            while (j <= right && (double) nums[i]/2 > nums[j]) j++;
            res += j-mid-1;
            i++;
        }
        int[] sort = new int[right-left+1];
        int index = 0;
        int i1 = left, i2 = mid+1;
        while (index < right-left+1) {
            if (i1 > mid) sort[index++] = nums[i2++];
            else if (i2 > right) sort[index++] = nums[i1++];
            else if (nums[i1] < nums[i2]) sort[index++] = nums[i1++];
            else sort[index++] = nums[i2++];
        }
        for (int k = 0; k < sort.length; k++) {
            nums[left+k] = sort[k];
        }
        return res;
    }
}