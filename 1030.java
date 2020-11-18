class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> distance(r0, c0, a)-distance(r0, c0, b));
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                queue.add(new int[]{x, y});
            }
        }
        int[][] res = new int[R*C][2];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;

    }

    private int distance(int r0, int c0, int[] point) {
        int x = point[0];
        int y = point[1];
        return Math.abs(r0-x) + Math.abs(c0-y);
    }
}