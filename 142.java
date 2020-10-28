/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;

        int length = 0;
        do {
            fast = fast.next.next;
            slow = slow.next;
            length++;
        } while (fast != slow);

        fast = head;
        slow = head;
        for (int i = 0; i < length; i++) {
            slow = slow.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}