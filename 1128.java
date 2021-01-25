class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] count = new int[100];
        for (int[] domino: dominoes) {
            Arrays.sort(domino);
            res += count[domino[0]*10+domino[1]]++;
        }
        return res;
    }
}