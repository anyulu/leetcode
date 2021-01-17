class Solution {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mapIndex = new HashMap<>();
        Map<String, String> mapName = new HashMap<>();
        int index = 0;

        for (List<String> account: accounts) {
            String name = account.get(0);
            int n = account.size();
            for (int i = 1; i < n; i++) {
                String email = account.get(i);
                if (!mapIndex.containsKey(email)) {
                    mapIndex.put(email, index++);
                    mapName.put(email, name);
                }
            }
        }

        parent = new int[index];
        for (int i = 1; i < index; i++) {
            parent[i] = i;
        }
        for (List<String> account: accounts) {
            int n = account.size();
            int index1 = mapIndex.get(account.get(1));
            for (int i = 2; i < n; i++) {
                union(mapIndex.get(account.get(i)), index1);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email: mapIndex.keySet()) {
            int p = find(mapIndex.get(email));
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(email);
        }

        for (List<String> emails: map.values()) {
            String name = mapName.get(emails.get(0));
            Collections.sort(emails);
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
}