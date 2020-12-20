class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int count = 0;
        while (temp > 0) {
            count += temp%2;
            temp >>= 1;
        }
        return count;
    }
}