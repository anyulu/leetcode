class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        for (int i = 0; i < m; i++) {
            int lo = 0;
            int hi = n;
            int mid = (lo+hi)/2;
            if (matrix[i][0] > target || matrix[i][n-1] < target) continue;
            while (lo <= hi) {
                mid = (lo+hi)/2;
                if (matrix[i][mid] < target) lo = mid+1;
                else if (matrix[i][mid] > target) hi = mid-1;
                else return true;
            }
        }
        System.out.print(m);
        return false;
    }
}