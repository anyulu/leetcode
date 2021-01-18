class Job {
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a,b) -> a.endTime-b.endTime);
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], jobs[i].profit);
            for (int j = i-1; j >= 0; j--) {
                if (jobs[j].endTime <= jobs[i].startTime) {
                    dp[i] = Math.max(dp[i], dp[j]+jobs[i].profit);
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}