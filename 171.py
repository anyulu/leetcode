class Solution:
    def titleToNumber(self, s: str) -> int:
        rev_s = s[::-1]
        res = 0
        multi = 0
        #print(ord('A'))
        for char in rev_s:
            res += (26**multi)*(ord(char)-64)
            multi += 1
        return res