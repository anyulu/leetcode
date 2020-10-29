class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        int max = 1;
        Arrays.sort(intervals, (a,b)->{return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];});
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < queue.peek()) {
                queue.add(intervals[i][1]);
                max = Math.max(max, queue.size());
                continue;
            }
            queue.add(intervals[i][1]);
            while (intervals[i][0] >= queue.peek()) queue.poll();
        }
        return max;
    }
}