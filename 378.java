class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int len = matrix[0].length;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (queue.size() == k) {
                    int num = queue.poll();
                    if (matrix[i][j] < num) queue.add(matrix[i][j]);
                    else queue.add(num);
                } else queue.add(matrix[i][j]);
            }
        }
        return queue.peek();
    }
}