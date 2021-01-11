class Solution {
    Map<Integer, Integer> degree;
    Map<Integer, List<Integer>> itemOrder;

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = i+m;
        }

        Map<Integer, Integer> groupDeg = new HashMap<>();
        Map<Integer, List<Integer>> beforeGroup = new HashMap<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        degree = new HashMap<>();
        itemOrder = new HashMap<>();

        for (int i = 0; i < n; i++) {
            groupDeg.putIfAbsent(group[i], 0);
            groupMap.computeIfAbsent(group[i], k -> new ArrayList<>()).add(i);
            degree.put(i, degree.getOrDefault(i, 0)+beforeItems.get(i).size());
            for (int pre: beforeItems.get(i)) {
                itemOrder.computeIfAbsent(pre, k -> new ArrayList<>()).add(i);
                if (group[pre] == group[i]) continue;
                beforeGroup.computeIfAbsent(group[pre], k -> new ArrayList<>())
                    .add(group[i]);
                groupDeg.put(group[i], groupDeg.get(group[i])+1);
            }
        }

        int size = groupDeg.size();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int key: groupDeg.keySet()) {
            if (groupDeg.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            size--;
            if (!helper(curr, group, groupMap.get(curr), res)) return new int[0];
            if (!beforeGroup.containsKey(curr)) continue;
            for (int next: beforeGroup.get(curr)) {
                groupDeg.put(next, groupDeg.get(next)-1);
                if (groupDeg.get(next) == 0) queue.offer(next);
            }
        }
        if (size != 0) return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean helper(int index, int[] group, List<Integer> items, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        int count = items.size();
        for (int item: items) {
            if (degree.get(item) == 0) queue.offer(item);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            count--;
            if (!itemOrder.containsKey(curr)) continue;
            for (int next: itemOrder.get(curr)) {
                degree.put(next, degree.get(next)-1);
                if (degree.get(next) == 0 && group[next] == index) queue.offer(next);
            }
        }
        return count == 0;
    }
}