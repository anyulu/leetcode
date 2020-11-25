class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) < len(nums2):
            nums1, nums2 = nums2, nums1
        len1 = len(nums1)
        len2 = len(nums2)
        lower = 0
        upper = 2*len2
        while lower <= upper:
            j = int((lower+upper)/2)
            i = int(len1+len2-j)
            if i == 0:
                L1 = float("-inf")
            else:
                L1 = nums1[int((i-1)/2)]
            R1 = nums1[int(i/2)] if i != 2*len1 else float("inf")
            L2 = nums2[int((j-1)/2)] if j != 0 else float("-inf")
            R2 = nums2[int(j/2)] if j != 2*len2 else float("inf")
            if L1 > R2:
                lower += 1
            elif R1 < L2:
                upper -= 1
            else:
                return (max(L1,L2)+min(R1,R2))/2 