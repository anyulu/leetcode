class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        connect = [[False]*n for _ in range(n)]
        degree = [0]*n
        for [a,b] in roads:
            connect[a][b] = True
            connect[b][a] = True
            degree[a] += 1
            degree[b] += 1
        
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                res = max(res, degree[i]+degree[j]-connect[i][j])
        return res
