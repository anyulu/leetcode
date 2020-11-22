class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[0] == point1[0])
                    return point1[1] > point2[1] ? 1 : -1;
                else return point1[0] > point2[1] ? 1 : -1;
            }
        });
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                res++;
            }
        }
        return res;
    }
}