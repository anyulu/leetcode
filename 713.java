class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int target) {
        int count = 0;
        if (arr.length == 0) return 0;
        int prod = 1;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            prod *= arr[i];
            while (prod >= target && start <= i) {
                prod /= arr[start++];
            }
            count += (i-start+1);
        }
        return count;
    }
}
