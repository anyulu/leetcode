class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        n = len(nums)
        m = len(l)
        res = []
        for i, j in zip(l, r):
            temp = sorted(nums[i:j+1])
            diff = temp[1]-temp[0]
            res.append(all(diff == m-n for n, m in pairwise(temp)))
        return res
