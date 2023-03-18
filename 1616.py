class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        n = len(a)
        return self.helper(a, b) or self.helper(b, a)
        
    def helper(self, a: str, b :str) -> bool: 
        n = len(a)
        l, r = 0, n-1
        while l < r and a[l] == b[r]:
            l += 1
            r -= 1
        if (l >= r):
            return True
        return self.checkIfPalindrome(a[l:r+1]) or self.checkIfPalindrome(b[l:r+1])

    def checkIfPalindrome(self, a: str) -> bool:
        n = len(a)
        for i in range(int(n/2)):
            if (a[i] != a[n-1-i]):
                return False
        return True