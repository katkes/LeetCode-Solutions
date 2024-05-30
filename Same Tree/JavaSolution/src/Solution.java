
public class Solution {

	/**
	 * Approach: The solution's idea is similar to a question that I've seen in my
	 * COMP 352 (Data Structure's and Algorithms) lecture. The concept is that a
	 * tree itself is composed of multiple subtrees where the smallest subtree is a
	 * node that has two null children. This is taken as the solution recursively
	 * checks the subtree going downwards from the root, checking the left side then
	 * the right side. If the node is both empty, that means it's reached the
	 * bottom. If we've managed to reach the bottom of every branch, it means the
	 * trees are the same. Else, a false would be returned and would be returned
	 * while the function-stack pops/shrinking. The traversal of the tree is
	 * pre-order traversal.
	 * 
	 * Time complexity: O(n) --> The worst time case is that the trees are the same,
	 * in this case each node is guaranteed to be visited only once. In this case,
	 * the time complexity is O(n) where n is the number of nodes of the trees.
	 * 
	 * Space complexity: O(min(p.height, q.height)) --> The worst case is going to
	 * be the minimum of the height of the two trees based off of the recursive
	 * nature of the solution. If they're different, the minimum height is the
	 * maximum number of stack calls at a given time as it could not got any deeper.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) // This is true if we've hit the bottom of the branch of the trees
			return true;

		if (p != null && q != null && (p.val == q.val)) // This is true if the two nodes being checked are not null AND
														// they're the same value, which means that we can go deeper.
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

		// This is ever reached when there's either a discrepancy of the number of nodes
		// with each tree or the two nodes being checked have different values
		return false;

	}

}
