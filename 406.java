class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> queue = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        for (int[] pair: people) queue.add(pair);
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) res[i][0] = -1;
        int count = -1;
        int index = 0;
        int prev = -1;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            if (pair[0] != prev) {
                prev = pair[0];
                count = -1;
                index = 0;
            }
            while (true) {
                if (res[index][0] == -1) {
                    count++;
                    if (count == pair[1]) break;
                }
                index++;
            }
            res[index] = pair;
        }
        return res;
    }
}