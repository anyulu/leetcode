class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n];
        res[n-1] = cost[n-1];
        res[n-2] = cost[n-2];
        for (int i = n-3; i >= 0; i--) {
            res[i] = cost[i]+Math.min(res[i+1], res[i+2]);
        }
        return Math.min(res[0], res[1]);
    }
}