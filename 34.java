class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int lo = 0;
        int hi = nums.length-1;
        int start = -1;
        int end = -1;
        int mid = (lo+hi)/2;
        while (lo <= hi) {
            mid = (lo+hi)/2;
            if (nums[mid] == target && (mid == 0 || nums[mid-1] != target)) break;
            else if (nums[mid] < target) lo = mid+1;
            else hi = mid-1;
        }
        start = mid;
        lo = 0;
        hi = nums.length-1;
        while (lo <= hi) {
            mid = (lo+hi)/2;
            if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] != target)) break;
            else if (nums[mid] > target) hi = mid-1;
            else lo = mid+1;
        }
        end = mid;
        if (nums[start] != target) return new int[]{-1,-1};
        return new int[]{start, end};
    }
}