class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return findMedian(nums2);
        if (n == 0) return findMedian(nums1);
        int n1 = 0;
        int start = 0, end = m;
        int n2 = (m+n+1)/2-n1;
        double res1 = 0;
        double res2 = 0;
        while (start <= end) {
            n1 = start+(end-start)/2;
            n2 = (m+n+1)/2-n1;
            int l1 = n1 == 0 ? Integer.MIN_VALUE : nums1[n1-1];
            int r1 = n1 == m ? Integer.MAX_VALUE : nums1[n1];
            int l2 = n2 == 0 ? Integer.MIN_VALUE : nums2[n2-1];
            int r2 = n2 == n ? Integer.MAX_VALUE : nums2[n2];
            if (l1 > r2) end = n1-1;
            else if (l2 > r1) start = n1+1;
            else {
                res1 = Math.max(l1, l2);
                res2 = Math.min(r1, r2);
                break;
            }
        }
        return (m+n) % 2 == 0 ? res1/2+res2/2 : res1;
    }

    private double findMedian(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n % 2 == 0) return (double) (nums[n/2]+nums[n/2-1])/2;
        return (double) nums[n/2];
    }
}