class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        res_set = []
        while n:
            if n == 1:
                return True
            if n not in res_set:
                res = sum(int(x)**2 for x in str(n))
                res_set.append(n)
                n = res
            else:
                return False

            