class Solution:
    def convert(self, num: int) -> int:
        if num == 0:
            return 0
        else:
            return 1 if num > 0 else -1

    def countSubarrays(self, nums: List[int], k: int) -> int:
        index = nums.index(k)
        res = 0
        counter = Counter()
        counter[0] = 1
        sum = 0
        for i in range(len(nums)):
            sum += self.convert(nums[i]-k)
            if i < index:
                counter[sum] += 1
            else:
                res1 = counter[sum]
                res2 = counter[sum - 1]
                res += res1 + res2
        print(counter)
        return res