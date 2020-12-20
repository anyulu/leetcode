class Solution {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int bit = 1;
        int[] res = new int[num+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (bit <= num) {
            Queue<Integer> temp = new LinkedList<>(queue);
            while (!queue.isEmpty()) temp.offer(queue.poll()+1);
            queue = temp;
            bit <<= 1;
        }
        for (int i = 0; i <= num; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}