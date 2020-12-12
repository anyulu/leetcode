class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            if (map.containsKey(i)) return true;
            map.put(i,1);
        }
        return false;
    }
}