/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode res = head, prev = null;
        int max = res.val;
        while (head != null) {
            if (head.val < res.val) {
                prev.next = head.next;
                head.next = res;
                res = head;
                head = prev.next;
            } else if (head.val < max) {
                ListNode temp = res;
                while (temp.next.val < head.val) temp = temp.next;
                prev.next = head.next;
                head.next = temp.next;
                temp.next = head;
                head = prev.next;
            } else {
                max = head.val;
                prev = head;
                head = head.next;
            }
        }
        return res;
    }
}