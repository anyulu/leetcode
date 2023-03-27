class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        m = len(s)
        n = len(t)
        dp1 = [[0]*(n+1) for i in range(m+1)]
        dp2 = [[0]*(n+1) for i in range(m+1)]
        res = 0

        for i in range(m):
            for j in range(n):
                dp1[i+1][j+1] = dp1[i][j]+1 if s[i] == t[j] else 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                dp2[i][j] = dp2[i+1][j+1]+1 if s[i] == t[j] else 0
        
        for i in range(m):
            for j in range(n):
                res += 0 if s[i] == t[j] else (dp1[i][j]+1)*(dp2[i+1][j+1]+1)
        return res
