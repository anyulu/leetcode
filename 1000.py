class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n - 1) % (k - 1) != 0:
            return -1

        dp = [[inf] * n for _ in range(n)]
        sums = [0] * n
        s = 0
        
        for i in range(n):
            dp[i][i] = 0
            s += stones[i]
            sums[i] = s

        for L in range(2, n + 1):
            for l in range(n - L + 1):
                r = l + L - 1
                for i in range(l, r, k - 1):
                    dp[l][r] = min(dp[l][r], dp[l][i] + dp[i + 1][r])
                if (r - l) % (k - 1) == 0:
                    dp[l][r] += (sums[r] - (0 if l == 0 else sums[l - 1]))
        return dp[0][n - 1]