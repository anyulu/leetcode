class Solution {
    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair: pairs) {
            union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = find(i);
            map.computeIfAbsent(curr, k -> new ArrayList<>()).add(s.charAt(i));
        }
        for (List<Character> list: map.values()) {
            Collections.sort(list);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int curr = find(i);
            List<Character> list = map.get(curr);
            res.append(list.get(0));
            list.remove(0);
        }
        return res.toString();
    }

    private int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 != p2) parent[p2] = p1;
    }
}