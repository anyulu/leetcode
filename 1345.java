class Solution {
    public int minJumps(int[] arr) {
        int step = 0;
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i+1 < n && i > 0 && arr[i] == arr[i-1] && arr[i] == arr[i+1]) continue;
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int m = queue.size();
            while (m-- > 0) {
                int curr = queue.poll();
                if (curr == n-1) return step;
                if (curr+1 < n && !set.contains(curr+1)) {
                    queue.offer(curr+1);
                    set.add(curr+1);
                }
                if (curr-1 >= 0 && !set.contains(curr-1)) {
                    queue.offer(curr-1);
                    set.add(curr-1);
                }
                for (int i: map.get(arr[curr])) {
                    if (i != curr && !set.contains(i)) {
                        queue.offer(i);
                        set.add(i);
                    }
                }
            }
            step++;
        }
        return step;
    }
}