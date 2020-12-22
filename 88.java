class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m >= 0 || n >= 0) {
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                break;
            }
            if (n == 0) break;
            if (nums1[m-1] < nums2[n-1]) {
                nums1[m+n-1] = nums2[--n];
            } else {
                nums1[m+n-1] = nums1[m-1];
                nums1[m-1] = 0;
                m--;
            }
        }
    }
}