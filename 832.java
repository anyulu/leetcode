class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        int size = A[0].length;
        int[][] result = new int[len][size];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++){
                result[i][j] = 1^A[i][size-1-j];
            }
        }

        return result;
    }
}