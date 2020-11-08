class Solution {
    public int connectSticks(int[] ropeLengths) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) queue.add(ropeLengths[i]);
        int res = 0;
        while (queue.size() >1) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            queue.add(sum);
        }
        return res;
    }
}