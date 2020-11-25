class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 1: return 1
        minx = 0
        maxx = x
        res = int((minx+maxx)/2)
        while maxx - minx > 1: 
            if res**2 > x:
                maxx = res
                res = int((minx+maxx)/2)
            elif res**2 < x:
                minx = res 
                res = int((minx+maxx)/2)
            else: return res
        return res

print(Solution().mySqrt(8))
