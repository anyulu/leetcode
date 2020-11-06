class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 2)-1);
        }
        int count = 0;
        for (Integer i: map.keySet()) {
            if (map.get(i) == 1) res[count++] = i;
        }
        return res;
    }
}