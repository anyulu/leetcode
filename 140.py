class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        res = []
        prefix = ''
        self.get_solution(s, wordDict, prefix, res)
        return res
                    
    def get_solution(self, s, wordDict, prefix, res):
        if s == '':
            res.append(prefix[:-1])
            return None
        else:
            if self.if_break(s, wordDict):
                for i in range(len(s)):
                    if s[:i+1] in wordDict:
                        self.get_solution(s[i+1:], wordDict, prefix + s[:i+1] + ' ', res)

    def if_break(self, s, wordDict):
        dp = [False] * len(s)
        for i in range(len(s)):
            for word in wordDict:
                if word == s[i-len(word)+1:i+1] and (dp[i-len(word)] or i<len(word)):
                    dp[i] = True
                    break
        return dp[-1]


        #### online solution
        # memo = {len(s): ['']}
        # print(memo)
        # def sentences(i):
        #     if i not in memo:
        #         memo[i] = [s[i:j] + (tail and ' ' + tail)
        #         for j in range(i+1, len(s)+1)
        #         if s[i:j] in wordDict
        #         for tail in sentences(j)]
        #     return memo[i]
        # return sentences(0)

        #### origin solution
        # dp = [0] * len(s)
        # all_dp = [dp]
        # all_solution = []
        # for i in range(len(s)):
        #     for word in wordDict:
        #         for j in range(len(all_dp)):
        #             choice = all_dp[j]
        #             if word == s[i-len(word)+1:i+1] and (choice[i-len(word)] or i<len(word)):
        #                 # print(choice, j, word, i)
        #                 # print(all_dp)
        #                 if sum(choice[i-len(word)+1:i+1]) == 0:
        #                     choice[i] = len(word)
        #                 else:
        #                     temp = choice[:]
        #                     temp[i-len(word)+1:i] = [0] * (len(word)-1)
        #                     temp[i] = len(word)
        #                     all_dp += [temp]
        # # all_dp = set(all_dp)
        # # print(all_dp)
        # for i in range(len(all_dp)):
        #     dp = all_dp[i]
        #     if dp[-1] != 0:
        #         temp = s
        #         index = len(s)
        #         while index >0:
        #             index -= dp[index-1]
        #             temp = temp[:index] + ' ' + temp[index:]  
        #         all_solution += [temp[1:]]
        # # all_solution
        # return list(set(all_solution))
        

print(Solution().wordBreak("aaa",["aaa","aa","a"]))