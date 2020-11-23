class Solution {
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 1) return nums[0] == 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = prime(nums[i], temp);
            if (temp == 1) return true;
        }
        return false;
    }

    private int prime(int n1, int n2) {
        int result = 0;
        while (n2 != 0) {
            result = n1 % n2;
            n1 = n2;
            n2 = result;
        }
        return n1;
    }
}