class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            int fast = next(nums, i);
            int slow = i;
            while (fast != slow && !visit[fast] && !visit[slow]) {
                if (nums[fast] * nums[next(nums, fast)] < 0) break;
                fast = next(nums, next(nums, fast));
                slow = next(nums, slow);
            }
            visit[i] = true;
            if (slow == next(nums, slow)) {
                visit[slow] = true;
                continue;
            } else if (slow == fast) return true;
        }
        return false;
    }

    private static int next(int[]nums, int curr) {
        int res = (curr+nums[curr]) % nums.length;
        return res >= 0 ? res : res+nums.length;
    }
}