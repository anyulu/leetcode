# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 != None and l2 != None:
            buff = l1.val + l2.val
            if buff >=10:
                buff -= 10
                if l1.next != None:
                    l1.next.val += 1
                elif l2.next != None:
                    l2.next.val += 1
                else:
                    overflow = ListNode(1)
                    l1.next = overflow
            res = ListNode(buff)
            res_next = Solution.addTwoNumbers(self, l1.next, l2.next)
            res.next = res_next
            return res
        elif l1 != None and l2 == None:
            buff = l1.val
            if buff >= 10:
                buff -= 10
                if l1.next != None:
                    l1.next.val += 1
                else:
                    overflow = ListNode(1)
                    l1.next = overflow
            res = ListNode(buff)
            res_next = Solution.addTwoNumbers(self, l1.next, None)
            res.next = res_next
            return res
        elif l1 == None and l2 != None:
            buff = l2.val
            if buff >= 10:
                buff -= 10
                if l2.next != None:
                    l2.next.val += 1
                else:
                    overflow = ListNode(1)
                    l2.next = overflow
            res = ListNode(buff)
            res_next = Solution.addTwoNumbers(self, None, l2.next)
            res.next = res_next
            return res
        else:
            return None