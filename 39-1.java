class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (index == candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        int c = candidates[index];
        if (target >= c) {
            list.add(c);
            dfs(res, list, candidates, target-c, index);
            list.remove((Integer) c);
        }
        dfs(res, list, candidates, target, index+1);
    }
}