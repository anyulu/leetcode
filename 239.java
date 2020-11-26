class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.addLast(i);
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            if (i >= k-1) res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
}