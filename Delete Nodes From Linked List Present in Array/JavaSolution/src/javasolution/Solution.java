package javasolution;

import java.util.HashSet;

public class Solution {
	public ListNode modifiedList(int[] nums, ListNode head) {

		HashSet<Integer> set = new HashSet<>();
		for (int num : nums)
			set.add(num);

		ListNode point = head;

		// Checks start and moves head
		while (point != null && set.contains(point.val)) {
			point = point.next;
			head = head.next;
		}

		// Checks within body
		while (point != null) {
			if (point.next != null && set.contains(point.next.val)) {
				while (point.next != null && set.contains(point.next.val))
					point.next = point.next.next; // deletes the next node
			}
			point = point.next;
		}

		return head;
	}
}