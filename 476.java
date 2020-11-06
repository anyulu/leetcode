class Solution {
    public int findComplement(int n) {
        if (n == 0) return 1;
        int count = 0, copy = n;
        while (copy > 0) {
            count++;
            copy = copy >> 1;
        }
        double res = Math.pow(2, count)-1;
        return (int)res^n;
    }
}