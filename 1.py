class Solution(object):
    def twoSum(self, nums, target):
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in nums and nums.index(diff) != i:
                return [nums.index(diff), i]