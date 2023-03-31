class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        n = len(nums)
        res = 0
        for i in range(n):
            curr = nums[i]
            if (((curr+diff) in nums) and ((curr+diff+diff) in nums)):
                res += 1
        return res