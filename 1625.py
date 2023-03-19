class Solution:
    def gcd(self, a: int, b: int):
        return abs(a) if b == 0 else self.gcd(b, a % b)
        
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        n = len(s)
        gcd = self.gcd(n, b)
        res = s
        s += s
        for i in range(0, n, gcd):
            temp = list(s[i:i+n])
            for k in range(10):
                for j in range(1, n, 2):
                    temp[j] = str((int(temp[j])+a) % 10)
                if b % 2 == 1:
                    for z in range(10):
                        for j in range(0, n, 2):
                            temp[j] = str((int(temp[j])+a) % 10)
                        res = min(res, ''.join(temp))
                else:
                    res = min(res, ''.join(temp))
        return res