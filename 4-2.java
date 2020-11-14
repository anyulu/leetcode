class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (helper(nums1, nums2, 0, m-1, 0, n-1, left)+
            helper(nums1, nums2, 0, m-1, 0, n-1, right))/2;
    }

    private double helper(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if (len1 > len2) return helper(nums2, nums1, start2, end2, start1, end1, k);
        if (len1 == 0) return nums2[start2+k-1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int index1 = start1+Math.min(k/2, len1)-1;
        int index2 = start2+Math.min(k/2, len2)-1;
        if (nums1[index1] > nums2[index2]) {
            return helper(nums1, nums2, start1, end1, index2+1, end2, k-(index2-start2+1));
        } else {
            return helper(nums1, nums2, index1+1, end1, start2, end2, k-(index1-start1+1));
        }
    }
}