
public class Solution {
	public ListNode insertGreatestCommonDivisors(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		int gcd, fastVal, slowVal, temp;

		while (fast != null) {

			fastVal = fast.val;
			slowVal = slow.val;

			while (fastVal != 0) {
				temp = fastVal;
				fastVal = slowVal % fastVal;
				slowVal = temp;
			}

			gcd = slowVal;

			slow.next = new ListNode(gcd, fast);
			slow = fast;
			fast = fast.next;
		}

		return head;
	}
}
