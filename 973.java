class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        if (points.length <= k) {
            for (int i = 0; i < points.length; i++) result[i] = points[i];
            return result;
        }
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> distFromOrigin(b)-distFromOrigin(a));
        for (int i = 0; i < k; i++) {
            queue.add(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (distFromOrigin(points[i]) < distFromOrigin(queue.peek())) {
                queue.poll();
                queue.add(points[i]);
            }
        }
        for (int i = 0; i < k; i++) result[i] = queue.poll();
        return result;
    }

    public int distFromOrigin(int[] x) {
        return (x[0] * x[0]) + (x[1] * x[1]);
    }

}