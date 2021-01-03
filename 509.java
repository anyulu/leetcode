class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int n1 = 0;
        int n2 = 1;
        while (n-- > 1) {
            n2 = n1+n2;
            n1 = n2-n1;
        }
        return n2;
    }
}