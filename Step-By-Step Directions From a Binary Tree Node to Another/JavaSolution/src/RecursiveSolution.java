public class RecursiveSolution {
	public String getDirections(TreeNode root, int startValue, int destValue) {
		String ret = "";

		String startNodePath = depthFirstSearch(root, "", startValue);
		String endNodePath = depthFirstSearch(root, "", destValue);

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

	private String depthFirstSearch(TreeNode node, String path, int target) {

		if (node == null) {
			return "";
		}

		if (node.val == target) {
			return path;
		}

		String leftPath = depthFirstSearch(node.left, path + "L", target);
		if (!leftPath.isEmpty())
			return leftPath;
		String rightPath = depthFirstSearch(node.right, path + "R", target);
		if (!rightPath.isEmpty())
			return rightPath;

		return "";
	}
}
