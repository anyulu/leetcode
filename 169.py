class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        curr_max = nums[0]
        for i in range(len(nums)):
            if nums[i] == curr_max:
                count += 1
            elif count == 1:
                curr_max = nums[i]
            elif count > 1:
                count -= 1
            else:
                count = 1
                curr_max = nums[i]
        return curr_max