
public class Solution {

	/**
	 * 
	 * Approach: The solution's idea is simple where the value is sequentially added
	 * by traversing the two linked lists at the same time and speed. The solution
	 * also has a carry aspect where in addition of base 10, you could get a carry
	 * which is why the carry variable exists. It's important to note that the two
	 * lists do NOT need to be the same length which is why the null checks are
	 * important. If they're not the same length, we would like to continue adding
	 * the remaining length of the longer linkedList to the new one anyways, which
	 * is why the solution effectively blocks out the shorten one by never
	 * considering a null field.
	 * 
	 * 
	 * Time complexity: O(n) --> The solution is guaranteed to traverse the greater
	 * length of the two linked lists, effectively making it a O(n) time complexity.
	 * 
	 * 
	 * Space complexity: O(n) --> The solution creates a new linked list that is
	 * guaranteed to be the greater length of the two linked lists, effectively
	 * making it a O(n) space complexity.
	 * 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0; // Carry number instantiated
		int p1Val;
		int p2Val;

		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode returnList = new ListNode();
		ListNode p3 = returnList;

		while (p1 != null || p2 != null) {

			p1Val = (p1 == null) ? 0 : p1.val; // Blocks progress if null
			p2Val = (p2 == null) ? 0 : p2.val; // Blocks progress if null

			p3.next = new ListNode((p1Val + p2Val + carry) % 10);
			carry = (p1Val + p2Val + carry) / 10;

			// Move the pointer to the next spot in the linked list
			// Note: Done except when it's null in the two given linked lists
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
			p3 = p3.next;
		}

		if (carry > 0) { // If there's a carry remaining, we would want to add at at the end
			p3.next = new ListNode(carry);
		}

		return returnList.next;
	}
}
