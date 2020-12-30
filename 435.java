class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, (a,b) -> {return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];});
        int n = intervals.length;
        int res = 1;
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return n-res;
    }
}