class Solution {
    int[] original;
    int[] array;

    public Solution(int[] nums) {
        array = nums;
        original = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = Arrays.copyOf(original, original.length);
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = array.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) swap(array, i, rand.nextInt(n));
        return array;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */