class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int rec = K;
        int count = 0;
        LinkedList<Integer> res = new LinkedList<>();
        while (rec > 0) {
            rec /= 10;
            count++;
        }
        int[] Ks = new int[count];
        while (K > 0) {
            Ks[--count] = K % 10;
            K /= 10;
        }
        int i1 = A.length-1;
        int i2 = Ks.length-1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0 || carry == 1) {
            int temp = carry;
            if (i1 >= 0) temp += A[i1--];
            if (i2 >= 0) temp += Ks[i2--];
            carry = temp/10;
            temp %= 10;
            res.addFirst(temp);
        }
        return res;
    }
}