/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode fast = head, slow = head, res = head;
        int len = 0;
        while (fast.next != null && fast.next.next != null) {
            len++;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            fast = fast.next;
            len++;
        }
        while (len > 0) {
            len--;
            ListNode prev = head;
            head = head.next;
            fast.next = head;
            prev.next = head.next;
            head = head.next;
            fast = fast.next;
        }
        fast.next = null;
        return res;
    }
}