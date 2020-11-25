class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0
        prime_set = [1] * n
        prime_set[0] = 0
        prime_set[1] = 0
        for i in range(2,int(n**0.5) + 1):
            if prime_set[i]:
                prime_set[i*2:n:i] = [0]*len(prime_set[i*2:n:i])
        return sum(prime_set)
print(Solution().countPrimes(499979))
