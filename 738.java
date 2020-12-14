class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        int res = 0;
        int prev = N % 10;
        N /= 10;
        int bit = 0;
        while (N > 0) {
            int curr = N % 10;
            N /= 10;
            if (curr <= prev) {
                res += Math.pow(10, bit++)*prev;
                prev = curr;
            } else {
                res = (int) Math.pow(10, ++bit)-1;
                prev = curr-1;
            }
        }
        res += Math.pow(10, bit)*prev;
        return res;
    }
}