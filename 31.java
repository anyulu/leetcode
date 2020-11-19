class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        int end = nums.length-1;
        while (i >= 0 && end > i) {
            if (nums[end] > nums[i]) {
                int temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                break;
            } else end--;
        }

        int start = i+1;
        end = nums.length-1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}