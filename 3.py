class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        values = []
        i = 0
        while i < len(s):
            if s[i] not in values:
                values.append(s[i])
            else:
                if len(values) > res: res = len(values)
                index = values.index(s[i])
                values = values[index+1:]
                values.append(s[i])
            print(values, i)
            i += 1
        return max(res, len(values))


