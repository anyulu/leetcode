class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        left = {'(': 0, '[': 1, '{': 2}
        right = {')':0 , ']': 1, '}': 2}
        pair = ['()', '[]', '{}']
        if len(s)%2 == 1: return False
        while len(s)> 0:
            for i in range(len(s)):
                if s[i] in left: 
                    if i == len(s)-1: return False
                    else: continue
                elif s[i] in right and i == 0: return False
                elif left[s[i-1]] != right[s[i]]: return False
                else:
                    s = s.replace(pair[right[s[i]]], '')
                    break
        return True