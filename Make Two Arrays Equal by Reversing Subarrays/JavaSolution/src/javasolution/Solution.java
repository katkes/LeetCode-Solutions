package javasolution;

import java.util.HashMap;

public class Solution {

	/***
	 * 
	 * Approach: The concept is that if the elements in both arrays are the same,
	 * regardless of order, then there exists an order of swaps that allows both
	 * arrays to be equal. To know if this is the case, a hashmap to keep track of
	 * the instances of each number is used.
	 * 
	 * Time complexity: O(n)--> The target and arr arrays are iterated once. This
	 * gives the solution a linear dependency giving a linear time complexity.
	 * 
	 * Space complexity: O(n)--> The range of keys range between [1,1000], however
	 * the size of the values of each key grows linearly with regards to the input
	 * size.
	 * 
	 * @param target
	 * @param arr
	 * @return
	 */
	public boolean canBeEqual(int[] target, int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : target) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int num : arr) {
			int val = map.getOrDefault(num, -1);

			// -1 if not found, 0 if empty --> both are a discrepancy
			if (val == -1 || val == 0)
				return false;

			map.put(num, val - 1);
		}

		return true;
	}
}
