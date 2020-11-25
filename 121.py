class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1: return 0
        diff = [0] * (len(prices)-1)
        for i in range(len(diff)):
            diff[i] = prices[i+1] - prices[i]
        cusum = [diff[0]] * len(diff)
        for i in range(1,len(diff)):
            cusum[i] = max(cusum[i-1], 0) + diff[i]
        return max(max(cusum),0)