class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double start = 0, end = 1;
        while (true) {
            int count = 0;
            int p = 0, q = 1;
            int i = 0, j = 0;
            double mid = (start+end)/2;
            for (; i < arr.length; i++) {
                while (j < arr.length && arr[i] > mid*arr[j]) {
                    j++;
                }
                count += arr.length-j;
                if (j < arr.length && arr[i]*q > arr[j]*p) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) return new int[]{p, q};
            if (count < k) start = mid;
            else end = mid;
        }
    }
}