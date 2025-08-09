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
        if (head.next == null && n == 1) return null;

        ListNode trail = head;
        ListNode lead = head;
        while (n > 0 && lead.next != null) {
            lead = lead.next;
            n--;
        }
        if (n != 0) return head.next;

        while (lead.next != null){
            trail = trail.next;
            lead = lead.next;
        }
        trail.next = trail.next.next;
        return head;
    }
}
