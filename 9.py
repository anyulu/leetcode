class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        rever_x = str(x)[::-1]
        if rever_x == str(x):
            return True
        else:
            return False
