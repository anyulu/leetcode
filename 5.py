class Solution:
    def longestPalindrome(self, s: str) -> str:
        l = len(s)
        if l <= 1: return s
        start_index = 0
        max_len = 1
        i = 0
        while i < l:
            m, n = i, i
            while m < l-1 and s[m+1] == s[m]: 
                m += 1
            while m < l-1 and n > 0 and s[m+1] == s[n-1]:
                m += 1
                n -=1
            buffer_len = m-n+1
            if buffer_len > max_len:
                start_index = n
                max_len = buffer_len
            i += 1
        return s[start_index:start_index+max_len]