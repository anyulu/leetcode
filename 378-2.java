class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        while (start < end) {
            int mid = start+(end-start)/2;
            int[] pair = new int[]{start, end};
            int count = count(matrix, mid, pair);
            if (count == k) return pair[0];
            if (count < k) start = pair[1];
            else end = pair[0];
        }
        return start;
    }

    private int count(int[][] matrix, int mid, int[] pair) {
        int row = matrix.length-1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= mid) {
                pair[0] = Math.max(matrix[row][col], pair[0]);
                count += (row+1);
                col++;
            } else {
                pair[1] = Math.min(matrix[row][col], pair[1]);
                row--;
            }
        }
        return count;
    }
}