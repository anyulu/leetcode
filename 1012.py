class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        listN = list(map(int, str(n)))
        N = len(listN)
        
        @cache
        def helper(i, limit, mask, hasDup):
            if i >= N:
                return 1 if hasDup else 0
            upperLimit = listN[i] if limit else 9
            res = 0
            for j in range(upperLimit + 1):
                tempLimit = limit and j == upperLimit
                tempMask = mask if mask == 0 and j == 0 else mask | (1 << j)
                tempHasDup = hasDup or (mask & (1 << j))
                res += helper(i + 1, tempLimit, tempMask, tempHasDup)
            return res
        return helper(0, True, 0, False)