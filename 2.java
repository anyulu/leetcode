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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode res = new ListNode();
        int input = 0;
        int v1 = -1;
        int v2 = -1;
        while (l1 != null || l2 != null || input == 1) {
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else v1 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            } else v2 = 0;
            int num = input+v1+v2;
            input = 0;
            if (num >= 10) {
                input = 1;
                num -= 10;
            }
            prev.next = new ListNode(num);
            if (prev.val == -1) res = prev.next;
            prev = prev.next;
        }
        return res;
    }
}