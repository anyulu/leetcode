# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        a,b = headA,headB
        lena,lenb = 0,0
        while a:
            lena += 1
            a = a.next
        while b:
            lenb += 1
            b = b.next
        a,b = headA,headB
        if lena > lenb:
            for i in range(lena-lenb):
                a = a.next
        elif lenb > lena:
            for i in range(lenb-lena):
                b = b.next
        while a != b:
            a = a.next 
            b = b.next 
        return a