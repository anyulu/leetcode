class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        for i in range(len(s)):
            index = t.find(s[i])
            if index == -1:
                return False
            else:
                t = t[0:index] + t[index+1:]
        if not t:
            return True
        else:
            return False