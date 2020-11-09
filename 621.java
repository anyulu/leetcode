class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        int count = 0;
        int res = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> buffer = new LinkedList<>();
        queue.addAll(map.values());
        while (count != map.size()) {
            if (queue.isEmpty()) queue.add(Integer.MAX_VALUE);
            int temp = queue.poll();
            temp--;
            if (temp == 0) count++;
            buffer.add(temp);
            res++;
            if (buffer.size() == n+1) queue.add(buffer.poll());
        }
        return res;
    }
}