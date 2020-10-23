class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> lines = new ArrayList<>();
        for (int[] building: buildings) {
            lines.add(new int[]{building[0], -building[2]});
            lines.add(new int[]{building[1], building[2]});
        }
        Collections.sort(lines, (a,b) -> {
            return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];
        });
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        queue.add(0);
        int temp = 0;
        for (int[] line: lines) {
            if (line[1] < 0) queue.add(-line[1]);
            else queue.remove(line[1]);
            if (queue.peek() != temp) {
                res.add(new ArrayList<>(Arrays.asList(line[0], queue.peek())));
                temp = queue.peek();
            }
        }
        return res;
    }
}