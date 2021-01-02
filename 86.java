/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode res = head;
        ListNode prev = null;
        Queue<ListNode> less = new LinkedList<>();
        Queue<ListNode> large = new LinkedList<>();
        while (head != null) {
            if (head.val < x) less.offer(head);
            else large.offer(head);
            head = head.next;
        }
        if (less.isEmpty() || large.isEmpty()) return res;
        while (!less.isEmpty()) {
            if (prev == null) {
                prev = less.poll();
                res = prev;
            } else {
                prev.next = less.poll();
                prev = prev.next;
            }
        }
        while (!large.isEmpty()) {
            prev.next = large.poll();
            prev = prev.next;
        }
        prev.next = null;
        return res;
    }
}