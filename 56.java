class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new LinkedList<>();
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b) -> {return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];});
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] i: intervals) {
            if (i[0] > right) {
                mergedIntervals.add(new int[]{left, right});
                left = i[0];
                right = i[1];
            } else right = Math.max(right, i[1]);
        }
        mergedIntervals.add(new int[]{left, right});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}

