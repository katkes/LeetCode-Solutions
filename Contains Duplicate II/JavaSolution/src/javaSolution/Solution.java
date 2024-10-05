package javaSolution;

import java.util.HashMap;

public class Solution {

	/**
	 * 
	 * Approach: The main difference between this question and the Contains
	 * Duplicate question is that there's a real need to track the index of numbers.
	 * The reason behind this is that we would return true if there's a duplicate
	 * where the absolute difference is smaller or equal to k. Because of this, a
	 * huge difference is the use of a hashmap opposed to a set as we would map an
	 * index to the value in the array to make sure that the abs difference <= k
	 * rule is complied.
	 * 
	 * 
	 * Time complexity: O(n) --> The array is iteratively gone through and the
	 * operations are constant, making it O(n).
	 * 
	 * Space complexity: O(n) --> The hashmap grows linearly in regards to input
	 * size.
	 * 
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				if (Math.abs(i - map.get(nums[i])) <= k)
					return true;
			map.put(nums[i], i);
		}

		return false;
	}
}
