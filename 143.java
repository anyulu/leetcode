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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            len += 2;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) len--;
        ListNode copy = head;
        ListNode reverseHalf = reverse(slow);
        int count = 0;
        while (count < len/2) {
            count++;
            ListNode temp = head.next;
            head.next = reverseHalf;
            reverseHalf = reverseHalf.next;
            head = head.next;
            head.next = temp;
            head = head.next;
        }
        head = copy;
        return;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}