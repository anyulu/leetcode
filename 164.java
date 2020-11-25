class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int dis = Math.max(1, (max-min)/(n-1));
        int[][] buckets = new int[(max-min)/dis+1][2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i][0] = buckets[i][1] = -1;
        }
        for (int i = 0; i < n; i++) {
            int index = (nums[i]-min)/dis;
            if (buckets[index][0] == -1) {
                buckets[index][0] = buckets[index][1] = nums[i];
            } else {
                buckets[index][0] = Math.min(buckets[index][0], nums[i]);
                buckets[index][1] = Math.max(buckets[index][1], nums[i]);
            }
        }
        int res = 0;
        int prev = buckets[0][1];
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][0] != -1) {
                res = Math.max(res, buckets[i][0]-prev);
                prev = buckets[i][1];
            }
        }
        return res;
    }
}