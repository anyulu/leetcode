class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = [nums[0]]
        for i in range(1, len(nums)):
            if nums[i] not in res: res.append(nums[i])
            else: res.remove(nums[i])
        return res[0]