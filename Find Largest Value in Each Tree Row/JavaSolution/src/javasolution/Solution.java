package javasolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	/***
	 * Approach: The problem can be broken down to two parts: Traversing each level
	 * and finding the maximum value for each level. The traversal is done with BFS
	 * where a queue is used, by a LinkedList implementation, to have an ordering
	 * based off of when an element is added to the queue. The code keeps track of
	 * each level as the while-loop gets re-evaluated for each level.
	 * 
	 * Time Complexity: O(n) --> The time the code takes is done linearly where it's
	 * linearly related to the size of the tree.
	 * 
	 * Space Complexity: O(n) --> The additional space needed with the LinkedList
	 * grows linearly with the size of the tree.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> largestValues(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		LinkedList<TreeNode> queue = new LinkedList<>();
		int max, len;

		if (root == null)
			return ret;
		queue.offer(root);

		while (!queue.isEmpty()) {
			len = queue.size(); // The number of nodes on a level
			max = Integer.MIN_VALUE;

			for (int i = 0; i < len; i++) {
				TreeNode currentNode = queue.poll();
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
				max = Math.max(max, currentNode.val);
			}

			ret.add(max);
		}

		return ret;

	}
}