class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        oribin='{:032b}'.format(n)
        reversebin=oribin[::-1]
        return int(reversebin,2)