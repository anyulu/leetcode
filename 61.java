/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int rotations) {
        if (head == null || rotations == 0) return head;
        ListNode prev = null, curr = head, start = head;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        int rot = len - rotations % len;
        if (rot == len) return curr;
        while (rot > 0) {
            prev = curr;
            curr = curr.next;
            rot--;
        }
        head.next = start;
        prev.next = null;
        return curr;
    }
}