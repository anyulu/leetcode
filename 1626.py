class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        res = 0
        dp = [0]*len(scores)
        sortedScore = sorted(zip(scores, ages))
        for i in range(len(scores)):
            for j in range(i):
                if sortedScore[i][1] >= sortedScore[j][1]:
                    dp[i] = max(dp[i], dp[j])
            dp[i] += sortedScore[i][0]
            res = max(res, dp[i])
        return res