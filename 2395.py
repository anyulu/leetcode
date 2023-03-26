class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        sums = set()
        for i in range(len(nums)-1):
            tempSum = nums[i]+nums[i+1]
            if tempSum in sums:
                return True
            sums.add(tempSum)
        return False
