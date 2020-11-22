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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, res = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count == n) return res.next;
        count = count-n-1;
        while (count > 0) {
            count--;
            head = head.next;
        }
        head.next = head.next.next;
        return res;
    }
}