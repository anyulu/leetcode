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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val-b.val);
        for (ListNode node: lists) {
            if (node != null) queue.add(node);
        }
        ListNode result = null;
        ListNode prev = null;
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            if (prev == null) {
                prev = curr;
                result = curr;
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            if (curr.next != null) queue.add(curr.next);
        }
        return result;
    }
}