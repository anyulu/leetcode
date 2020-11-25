# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        temp = []
        while head:
            temp.append(head.val)
            head = head.next
        for i in range(len(temp)/2):
            if temp[i] != temp[len(temp)-i-1]:
                return False
        return True