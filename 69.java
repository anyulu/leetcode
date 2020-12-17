class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int res = 1;
        int l = 1, r = x;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if ((double) mid*mid <= x) {
                res = mid;
                l = mid+1;
            } else r = mid-1;
        }
        return res;
    }
}