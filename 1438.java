class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>((a,b) -> b-a);
        int res = 1;
        for (int start = 0, end = 0; end < nums.length; end++) {
            minQ.add(nums[end]);
            maxQ.add(nums[end]);
            if (maxQ.peek()-minQ.peek() <= limit) {
                res = Math.max(res, end-start+1);
            } else {
                minQ.remove((Integer) nums[start]);
                maxQ.remove((Integer) nums[start]);
                start++;
            }
        }
        return res;
    }
}