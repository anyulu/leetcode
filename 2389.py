class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n, m = len(nums), len(queries)
        res = [0]*m
        sums = [0]*(n+1)
        nums = sorted(nums)
        for i in range(n):
            sums[i+1] = sums[i]+nums[i]
        print(sums)
        for i in range (m):
            l, r = 0, n
            mid = int((l+r)/2)
            while l < r:
                if (sums[mid] == queries[i]):
                    break
                if (sums[mid] < queries[i]):
                    l = mid
                else:
                    r = mid-1
                mid = int((l+r+1)/2)
            res[i] = mid
        return res
                

