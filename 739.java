class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> T[a]-T[b]);
        queue.add(0);
        for (int i = 1; i < T.length; i++) {
            int prev = queue.peek();
            if (T[i] <= T[prev]) {
                queue.add(i);
                continue;
            }
            queue.add(i);
            while (T[i] > T[prev]) {
                res[prev] = i-prev;
                queue.poll();
                prev = queue.peek();
            }
        }
        return res;
    }
}