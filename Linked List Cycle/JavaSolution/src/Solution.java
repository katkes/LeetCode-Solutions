public class Solution {

	/**
	 * Approach: This is a fast/slow pointer approach. The idea is that if there's a
	 * cycle in the LinkedList, the slow and fast pointers must meet at some point
	 * if they're going at separate speeds. In other words, the fast pointer will
	 * loop the slow pointer if there's a loop. To see that they've met, the
	 * 
	 * Time complexity: O(n) --> There will be some constant k amount of times that
	 * the fast pointer will have to iterate the LinkedList in it's worst case to
	 * meet the slow pointer.
	 * 
	 * Space complexity: O(1) --> In place, only two pointers are ever initialized.
	 * 
	 * @param head --> Start of the LinkedList
	 * @return True or False based on whether there's a cycle or not
	 */
	public boolean hasCycle(ListNode head) {

		// Fast and slow pointer initialization
		ListNode fast = head;
		ListNode slow = head;

		// While condition checks if there's an end, exits while-loop if there's an end
		// to the list
		while (fast != null && fast.next != null) {

			// Fast goes twice as fast as slow
			fast = fast.next.next;
			slow = slow.next;

			// Fast and slow pointers have met, there's a loop
			if (fast == slow) {
				return true;
			}

		}

		// There's no loop since it left the while-loop, there's an end to the list
		return false;

	}
}