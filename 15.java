// bruce-force
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i+1; j < nums.length; j++) {
                if (map.containsKey(-nums[i]-nums[j])) {
                    List<Integer> temp = new ArrayList<Integer>(
                        Arrays.asList(nums[i],nums[j],-nums[i]-nums[j]));
                    Collections.sort(temp);
                    set.add(temp);
                }
                map.put(nums[j],j);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(set);
        return res;
    }
}

