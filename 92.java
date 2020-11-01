/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int p, int q) {
        if (p == q) return head;
        ListNode headCopy = head;
        ListNode prev = null, curr = head;
        int i = 1;
        while (curr != null & i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode start = prev;
        ListNode end = curr;
        prev = null;
        for (i = 0; curr != null & i < q-p+1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if (start != null) start.next = prev;
        else headCopy = prev;
        end.next = curr;
        return headCopy;
    }
}