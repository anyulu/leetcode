class Solution {
    public int firstMissingPositive(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        for (int i = 0; i < nums.length+1; i++) {
            queue.add(i+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) queue.remove(nums[i]);
        }
        return queue.peek();
    }
}