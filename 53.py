class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        l = len(nums)
        if l == 0: return 0
        for i in range(l-1):
            if nums[i] > 0: nums[i+1] += nums[i] 
        return max(nums)