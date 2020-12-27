class Results {
    int k;
    int profit;

    public Results(int k, int profit) {
        this.k = k;
        this.profit = profit;
    }
}

class Solution {
    int[][] empty;
    int[][] have;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        empty = new int[n][k+1];
        have = new int[n][k+1];
        return dfs(k, prices, false, 0);
    }

    private int dfs(int k, int[] prices, boolean hold, int index) {
        if (index == prices.length || (k == 0 && !hold)) return 0;

        if (!hold) {
            if (empty[index][k] > 0) return empty[index][k];
            int res = dfs(k, prices, false, index+1);
            if (k > 0) res = Math.max(res, dfs(k-1, prices, true, index+1)-prices[index]);
            empty[index][k] = res;
            return res;
        } else {
            if (have[index][k] > 0) return have[index][k];
            int res = dfs(k, prices, true, index+1);
            res = Math.max(res, dfs(k, prices, false, index+1)+prices[index]);
            have[index][k] = res;
            return res;
        }
    }
}

// DFS TLE
class Results {
    int k;
    int profit;

    public Results(int k, int profit) {
        this.k = k;
        this.profit = profit;
    }
}

class Solution {
    int max;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        max = 0;
        dfs(0, k, prices, false, 0);
        return max;
    }

    private void dfs(int res, int k, int[] prices, boolean hold, int index) {
        if (index == prices.length || (k == 0 && !hold)) {
            return;
        }

        if (!hold) {
            if (k > 0) dfs(res-prices[index], k-1, prices, true, index+1);
            dfs(res, k, prices, false, index+1);
        } else {
            max = Math.max(max, res+prices[index]);
            dfs(res+prices[index], k, prices, false, index+1);
            dfs(res, k, prices, true, index+1);
        }
    }
}