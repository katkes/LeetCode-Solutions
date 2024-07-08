public class Solution {

	class ListNode {
		class Node {
			int value;
			Node next;

			public Node(int value) {
				super();
				this.value = value;
			}

		}

		Node head;
		Node tail;

		public ListNode() {
		}

		public void add(int x) {
			if (head == null) {
				head = new Node(x);
				tail = head;
				tail.next = head;
			} else {
				tail.next = new Node(x);
				tail = tail.next;
				tail.next = head;
			}
		}
	}

	/**
	 * 
	 * Approach: The solution itself is thought out where the group of friends is
	 * visualized as a circular, one-way linked list. With this, the approach sets
	 * up the linked list with a slow pointer and current pointer to facilitate with
	 * removing the friend at each turn. While the solution isn't optimal, it serves
	 * as a good representation to how each turn is simulated with who's selected to
	 * be kicked out and who's remaining.
	 * 
	 * Time complexity: O(n) --> The linked list is populated with n terms and
	 * you're guaranteed to have n-1 simulations. Overall, the amount of operations
	 * follows a linear progression in regards to the input size for given reasons.
	 * 
	 * Space complexity: O(n) --> The size of the linked list is linearly relational
	 * to the input size of n, making it O(n) additional space.
	 * 
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int findTheWinner(int n, int k) {

		ListNode list = new ListNode();

		int count;

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		Solution.ListNode.Node slow = list.tail;
		Solution.ListNode.Node current = list.head;

		// Stop when only one person is left
		while (slow != current) {
			count = k - 1; // Offshift the count by one to account that you include the current person

			while (count > 0) {
				slow = slow.next;
				current = current.next;
				count--;
			}

			// Code to kick out the person at a given turn
			slow.next = current.next;
			current = slow.next;

		}

		return current.value;
	}
}
