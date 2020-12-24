class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i: s) {
            queue.offer(i);
        }
        int index = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() >= g[index]) {
                index++;
                queue.poll();
                res++;
            } else {
                queue.poll();
            }
            if (index == g.length) {
                return res;
            }
        }
        return res;
    }
}