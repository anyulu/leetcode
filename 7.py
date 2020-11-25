class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x >= 0:
            sign = 1
        else:
            sign = -1
        rev = str(abs(x))[::-1]
        res = int(rev)*sign
        if res <-2**31 or res > 2**31-1:
            return 0
        return res
    
