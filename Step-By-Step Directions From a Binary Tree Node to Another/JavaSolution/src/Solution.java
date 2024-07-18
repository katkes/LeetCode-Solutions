import java.util.Stack;

public class Solution {

	class Pair {
		private TreeNode node;
		private String path;

		public Pair(TreeNode node, String path) {
			this.node = node;
			this.path = path;
		}

		public TreeNode getNode() {
			return node;
		}

		public String getPath() {
			return path;
		}

	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		String ret = "";

		String startNodePath = depthFirstSearch(root, startValue);
		String endNodePath = depthFirstSearch(root, destValue);

		int i = 0;
		while (i < Math.min(startNodePath.length(), endNodePath.length())
				&& startNodePath.charAt(i) == endNodePath.charAt(i)) {
			i++;
		}

		for (int j = 0; j < startNodePath.substring(i).length(); j++) {
			ret += "U";
		}

		ret += endNodePath.substring(i);

		return ret;
	}

	private String depthFirstSearch(TreeNode root, int target) {

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, "")); // initialize path starting from root

		while (!stack.isEmpty()) {
			Pair currentPair = stack.pop();
			TreeNode node = currentPair.node;
			String path = currentPair.path;

			if (node.val == target) {
				return path;
			}

			if (node.right != null) {
				stack.push(new Pair(node.right, path + "R"));
			}

			if (node.left != null) {
				stack.push(new Pair(node.left, path + "L"));
			}

		}

		return "";

	}
}
