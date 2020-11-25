class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        values = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        l = len(s)
        inv_s = s[::-1]
        res = values[inv_s[0]]
        for i in range(l-1):
            if values[inv_s[i]] > values[inv_s[i+1]]:
                res -= values[inv_s[i+1]]
            else:
                res += values[inv_s[i+1]]
        return res