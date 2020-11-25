# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        res = ListNone(0)
        act = res
        while l1 is not None and l2 is not None:
            if l1.val >= l2.val:
                res.next = ListNode(l2.val)
                l2 = l2.next
                res = res.next
            else:
                res.next = ListNode(l1.val)
                l1 = l1.next 
                res = res.next
        if l1 is None:
            res.next = l2
        else:
            res.next = l1
        return act.next
