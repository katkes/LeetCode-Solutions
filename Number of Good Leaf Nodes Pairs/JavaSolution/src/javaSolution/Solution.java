package javaSolution;

import java.util.ArrayList;

public class Solution {

	int count = 0;

	public int countPairs(TreeNode root, int distance) {

		dfs(root, distance);

		return count;

	}

	public ArrayList<Integer> dfs(TreeNode root, int distance) {
		if (root == null) {
			return new ArrayList<>(); // Return empty list if node is null
		}

		if (root.left == null && root.right == null) {
			ArrayList<Integer> distances = new ArrayList<>();
			distances.add(1); // Return distance of once if it's a leaf-node
			return distances;
		}

		ArrayList<Integer> left = dfs(root.left, distance); // Left child
		ArrayList<Integer> right = dfs(root.right, distance); // Right child

		for (int leftNode : left) {
			for (int rightNode : right) {
				int totalDistance = leftNode + rightNode;
				// Good pair check
				if (totalDistance <= distance) {
					count++; 
				}
			}
		}
		
		// Increment distances from left subtree
        for (int i = 0; i < left.size(); i++) {
            left.set(i, left.get(i) + 1);
        }

        // Merge right subtree into left, while incrementing size
        for (int i = 0; i < right.size(); i++) {
            left.add(right.get(i) + 1);
        }

        return left; 
	}
}
