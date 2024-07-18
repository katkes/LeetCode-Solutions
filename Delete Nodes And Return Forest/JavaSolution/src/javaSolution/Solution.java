package javaSolution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		HashSet<Integer> setToDelete = new HashSet<>();
		HashSet<TreeNode> setOfNodes = new HashSet<>();

		for (int delete : to_delete)
			setToDelete.add(delete);

		setOfNodes.add(root);

		postOrderRemoval(root, setToDelete, setOfNodes);

		List<TreeNode> forest = new LinkedList<>();

		for (TreeNode node : setOfNodes) {
			forest.add(node);
		}

		return forest;

	}

	private void postOrderRemoval(TreeNode root, HashSet<Integer> setToDelete, HashSet<TreeNode> setOfNodes) {
		if (root.left != null)
			postOrderRemoval(root.left, setToDelete, setOfNodes);
		if (root.right != null)
			postOrderRemoval(root.right, setToDelete, setOfNodes);

		// if you're the problem, let go
		if (setToDelete.contains(root.val)) {
			if (root.left != null && !setToDelete.contains(root.left.val))
				setOfNodes.add(root.left);
			if (root.right != null && !setToDelete.contains(root.right.val))
				setOfNodes.add(root.right);
			if (setOfNodes.contains(root))
				setOfNodes.remove(root);
			return;
		}

		if (root.left != null && setToDelete.contains(root.left.val)) {
			root.left = null;
		}
		if (root.right != null && setToDelete.contains(root.right.val))
			root.right = null;

	}
}
