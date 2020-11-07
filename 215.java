class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}