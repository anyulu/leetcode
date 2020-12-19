class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) count++;
            else if (count <= 1) {
                count = 1;
                res = nums[i];
            } else count--;
        }
        return res;
    }
}