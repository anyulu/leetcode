class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num: nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(subsets.get(i));
                temp.add(num);
                subsets.add(temp);
            }
        }
        return subsets;
    }
}