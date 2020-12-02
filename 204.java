class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) res++;
        }
        return res;
    }

    private boolean isPrime(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0 && n != i) return false;
        }
        return true;
    }
}