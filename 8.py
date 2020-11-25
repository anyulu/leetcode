class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        if_start = False
        sign = 1
        res = 0
        num = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']

        if len(str) == 0:
            return 0

        for s in str:
            if if_start == False:
                if s == ' ':
                    continue
                elif s == '-':
                    sign = -1
                    if_start = True
                elif s == '+':
                    if_start = True 
                elif s in num:
                    if_start = True
                    res = int(s)
                else:
                    if_start = True
                    res = 0
                    break
            else:
                if s in num:
                    res = res * 10 + int(s)
                else:
                    break
        res *= sign
        if res < -2**31:
            return -2**31
        elif res > 2**31-1:
            return 2**31-1
        else:
            return res