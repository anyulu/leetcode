# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if len(nums) == 0: 
            return None
        half = int(len(nums)/2)
        root = TreeNode(nums[half])
        root.left = self.sortedArrayToBST(nums[:half])
        root.right = self.sortedArrayToBST(nums[half+1:])
        return root