class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[j]++;
                } else {
                    dp[j] = 0;
                }
            }
            max = Math.max(max, helper(dp));
        }
        return max;
    }

    private int helper(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                max = Math.max(max, arr[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, arr[stack.pop()]*(n-stack.peek()-1));
        }
        return max;
    }
}