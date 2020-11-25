# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None: return True
        return self.issame(root.left, root.right)
        
    def issame(self, root1: TreeNode, root2: TreeNode) -> bool:
        if root1 is None and root2 is None: 
            return True
        elif root1 is None or root2 is None: 
            return False
        elif root1.val != root2.val: 
            return False
        else:
            return self.issame(root1.left, root2.right) and self.issame(root1.right, root2.left)

