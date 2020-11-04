class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Queue<Integer> startHeap = new PriorityQueue<Integer>(
            (a,b) -> intervals[a][0]-intervals[b][0]);
        Queue<Integer> endHeap = new PriorityQueue<Integer>(
            (a,b) -> intervals[a][1]-intervals[b][1]);
        for (int i = 0; i < intervals.length; i++) {
            startHeap.add(i);
            endHeap.add(i);
            result[i] = -1;
        }
        while (!endHeap.isEmpty()) {
            int curr = endHeap.poll();
            while (!startHeap.isEmpty()) {
                if (intervals[startHeap.peek()][0] >= intervals[curr][1]) {
                    result[curr] = startHeap.peek();
                    break;
                } else startHeap.poll();
            }
        }
        return result;
    }
}