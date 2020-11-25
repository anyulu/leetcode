class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        temp = []
        curr_num = 0
        last_sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                curr_num  = curr_num*10 + int(s[i])
                if i != len(s)-1: continue
            if s[i] in ['+','-','*','/'] or i == len(s)-1:
                if last_sign == '+':
                    temp.append(curr_num)
                elif last_sign == '-':
                    temp.append(-curr_num)
                elif last_sign == '*':
                    last_num = temp.pop()
                    temp.append(last_num*curr_num)
                elif last_sign == '/':
                    last_num = temp.pop()
                    temp.append(int(last_num/curr_num))
                curr_num = 0
                last_sign = s[i]
        return sum(temp)