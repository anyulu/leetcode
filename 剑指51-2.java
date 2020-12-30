class Solution {
    int[] res;
    int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        res = new int[n];
        mergeSort(nums, 0, n-1);
        return count;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, r, mid);
    }

    public void merge(int[] nums, int l, int r, int mid) {
        int i = l, j = mid+1;
        int[] temp = new int[r-l+1];
        for (int k = 0; k < r-l+1; k++) {
            if (i > mid) {
                temp[k] = nums[j++];
            } else if (j > r) {
                temp[k] = nums[i++];
            } else if (nums[i] > nums[j]) {
                count += mid-i+1;
                temp[k] = nums[j++];
            } else {
                temp[k] = nums[i++];
            }
        }
        for (int k = 0; k < r-l+1; k++) {
            nums[k+l] = temp[k];
        }
    }
}