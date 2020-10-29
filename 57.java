class Solution {
    public int[][] insert(int[][] intervalsArray, int[] newInterval) {
        List<int[]> mergedIntervals = new LinkedList<>();
        List<int[]> intervals = new ArrayList<>(Arrays.asList(intervalsArray));
        intervals.add(newInterval);
        Collections.sort(intervals, (a,b) -> {return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];});
        int left = intervals.get(0)[0], right = intervals.get(0)[1];
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