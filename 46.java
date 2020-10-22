class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, boolean[] ifUsed, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ifUsed[i]) continue;
            ifUsed[i] = true;
            list.add(nums[i]);
            dfs(res, nums, ifUsed, list);
            list.remove(list.size()-1);
            ifUsed[i] = false;
        }
    }
}