class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        n = len(str1)
        m = len(str2) 
        f = [[0] * (m + 1) for _ in range(n + 1)]

        for i in range(m+1):
            f[0][i] = i
        for i in range(n+1):
            f[i][0] = i
        for i, x in enumerate(str1):
            for j, y in enumerate(str2):
                if x == y:
                    f[i+1][j+1] = f[i][j] + 1
                else: 
                    f[i+1][j+1] = min(f[i][j+1], f[i+1][j]) + 1

        res = []
        i, j = n - 1, m - 1
        while i >= 0 and j >= 0:
            if str1[i] == str2[j]:
                res.append(str1[i])
                i -= 1
                j -= 1
            elif f[i+1][j+1] == f[i][j+1] + 1:
                res.append(str1[i])
                i -= 1
            else:
                res.append(str2[j])
                j -= 1

        return str1[:i + 1] + str2[:j + 1] + ''.join(reversed(res))