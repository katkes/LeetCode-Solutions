package javasolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
	public long kthLargestLevelSum(TreeNode root, int k) {
		long largestSum = -1;
		long currentSum = 0;
		HashSet<TreeNode> current = new HashSet<>();
		HashSet<TreeNode> next = new HashSet<>();
		ArrayList<Long> list = new ArrayList<>();

		current.add(root);

		while (!current.isEmpty()) {
			Iterator<TreeNode> iterator = current.iterator();
			while (iterator.hasNext()) {
				TreeNode node = iterator.next();
				currentSum += (long) node.val;
				iterator.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
			}

			if (!next.isEmpty() && current.isEmpty()) {
				current = next;
				next = new HashSet<>();
			}
			list.add(currentSum);
			currentSum = 0;
		}

		Collections.sort(list, Collections.reverseOrder());

		if (k <= list.size()) {
			largestSum = list.get(k - 1);
		} else
			largestSum = -1;

		return largestSum;
	}
}
