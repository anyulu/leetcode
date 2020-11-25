class Solution:
    def trailingZeroes(self, n: int) -> int:
        div = n
        count = 0
        while div >= 1:
            count += div//5
            div = div//5
        return count