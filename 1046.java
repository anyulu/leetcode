class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (int stone: stones) {
            queue.offer(stone);
        }
        while (queue.size() >= 2) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            if (s1 != s2) {
                queue.offer(s1-s2);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}