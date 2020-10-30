/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule.size() == 0) return result;
        List<int[]> time = new ArrayList<>();
        for (List<Interval> interval: schedule) {
            for (Interval i: interval) {
                time.add(new int[]{i.start, -1});
                time.add(new int[]{i.end, 1});
            }
        }
        Collections.sort(time, (a,b)->{return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];});
        Queue<Integer> queue = new PriorityQueue<>();
        boolean free = false;
        int freeTime = 0;
        queue.add(0);
        for (int[] i: time) {
            if (i[1] == -1) queue.add(-1);
            else queue.remove(-1);
            if (free) {
                result.add(new Interval(freeTime, i[0]));
                free = false;
            }
            if (queue.peek() == 0) {
                freeTime = i[0];
                free = true;
            }
        }
        return result;
    }
}