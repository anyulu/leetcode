class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = A[0];
        res.add(num == 0);
        for (int i = 1; i < A.length; i++) {
            num <<= 1;
            num |= A[i];
            num %= 5;
            res.add(num == 0);
        }
        return res;
    }
}