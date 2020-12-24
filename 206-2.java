/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }
        ListNode curr = deque.pollLast();
        ListNode res = curr;
        while (!deque.isEmpty()) {
            curr.next = deque.pollLast();
            curr = curr.next;
        }
        curr.next = null;
        return res;
    }
}

// 迭代
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}