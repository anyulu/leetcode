class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m
        j = n
        while i > 0 and j > 0:
            if nums1[i-1] >= nums2[j-1]:
                nums1[i+j-1] = nums1[i-1]
                i -= 1
            else:
                nums1[i+j-1] = nums2[j-1]
                j -= 1
        if j > 0:
            nums1[:j] = nums2[:j]