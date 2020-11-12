class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int next = 1;
        while (i < A.length) {
            if ((i % 2 == 0 && A[i] % 2 == 0) ||
                (i % 2 == 1 && A[i] % 2 == 1)) {
                i++;
                next = 1;
            } else {
                int temp = A[i+next];
                A[i+next] = A[i];
                A[i] = temp;
                next++;
            }
        }
        return A;
    }
}