class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i-1]) start = end;
            end = subsets.size();
            for (int j = start; j < end; j++) {
                List<Integer> temp = new ArrayList(subsets.get(j));
                temp.add(nums[i]);
                subsets.add(temp);
            }
        }
        return subsets;
    }
}