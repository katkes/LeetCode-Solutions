import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public TreeNode createBinaryTree(int[][] descriptions) {
		HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
		HashSet<Integer> childrenSet = new HashSet<>();
		int parentValue;
		int childValue;
		boolean isLeft;

		for (int[] node : descriptions) {
			parentValue = node[0];
			childValue = node[1];
			isLeft = node[2] == 1;

			// Parent node added
			if (!nodeMap.containsKey(parentValue)) {
				nodeMap.put(parentValue, new TreeNode(parentValue));
			}

			if (!nodeMap.containsKey(childValue)) {
				nodeMap.put(childValue, new TreeNode(childValue));
			}

			if (isLeft) {
				nodeMap.get(parentValue).left = nodeMap.get(childValue);
			} else {
				nodeMap.get(parentValue).right = nodeMap.get(childValue);
			}

			childrenSet.add(childValue);

		}

		for (int key : nodeMap.keySet()) {
			if (!childrenSet.contains(key))
				return nodeMap.get(key);
		}

		return null;

	}

}
