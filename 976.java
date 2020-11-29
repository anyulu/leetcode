class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int n1 = A[n-1];
        int n2 = A[n-2];
        int i = n-3;
        while (i >= 0 && A[i]+n2 <= n1) {
            n1 = n2;
            n2 = A[i--];
        }
        if (i == -1) return 0;
        return n1+n2+A[i];
    }
}