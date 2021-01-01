class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            if (i >= k-1) {
                if ( i >= k && nums[i-k] == queue.peekFirst()) queue.pollFirst();
                res[i-k+1] = queue.peekFirst();
            }
        }
        return res;
    }
}