class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1: return 0
        diff = [0] * (len(prices)-1)
        for i in range(len(diff)):
            diff[i] = prices[i+1] - prices[i]
        return sum(diff[i] for i in range(len(diff)) if diff[i] >= 0)