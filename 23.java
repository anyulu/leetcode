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
        int k = lists.length;
        if (k == 0) return null;
        if (k == 1) return lists[0];
        int currMin = Integer.MAX_VALUE;
        int currIndex = 0;
        for (int i = 0; i < k; i++) {
            if (lists[i] == null) continue;
            if (lists[i].val < currMin) {
                currMin = lists[i].val;
                currIndex = i;
            }
        }
        if (currMin == Integer.MAX_VALUE) return null;
        lists[currIndex] = lists[currIndex].next;
        ListNode temp = new ListNode();
        temp.val = currMin;
        temp.next = mergeKLists(lists);
        return temp;
    }
}