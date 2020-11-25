class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        l = len(digits)
        if l == 0: return [1]
        if digits[-1] != 9:
            digits[-1] += 1
        else:
            digits = self.plusOne(digits[:-1]) + [0]
        return digits