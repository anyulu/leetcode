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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode prev = null, curr = head;
        ListNode start = prev, end = curr;
        boolean reverse = true;
        while (true) {
            start = prev;
            end = curr;
            for (int i = 0; i <k-1; i++) {
                curr = curr.next;
                if (curr == null) {
                    reverse = false;
                    break;
                }
            }
            if (!reverse) break;
            curr = end;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if (start != null) start.next = prev;
            else head = prev;

            end.next = curr;
            prev = end;
            if (curr == null) break;
        }
        return head;
    }
}