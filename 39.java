class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target);
        HashSet<List<Integer>> set = new HashSet<>();
        for (List<Integer> list: res) {
            Collections.sort(list);
            set.add(list);
        }
        res.clear();
        res.addAll(set);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int c: candidates) {
            if (c > target) continue;
            list.add(c);
            dfs(res, list, candidates, target-c);
            list.remove((Integer) c);
        }
    }
}