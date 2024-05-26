import java.util.HashSet;

public class Solution {

	/**
	 * Approach: The solution's idea is to go through each number and see if it's
	 * already in the array. While the intuitive solution is to use two for-loops to
	 * see every combination, this results in a heavy runtime of O(n^2). Instead,
	 * Java's HashSet class can be utilized as accessing it to see if it contains a
	 * number is an expected O(1) time, with the under-the-hood hashing aspect of
	 * the HashSet. As a result, looping through the array once is sufficient as you
	 * can first check each number exists in the set, if true then return true. If
	 * not then add it to the set (takes O(1) time) and continue through the array.
	 * 
	 * Time complexity: O(n) --> At worst, every number of the nums array is
	 * accessed to see if there's a duplicate where in the worst time complexity
	 * case, doesn't exist. Having to access all numbers of the array would make it
	 * O(n).
	 * 
	 * Space complexity: O(n) --> At worst, every number of the nums array is stored
	 * in the set. This only happens if there isn't a duplicate. This would result
	 * in the space complexity of being O(n).
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		
		// Initialization of the HashSet to track our numbers
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int x : nums) {
			if (set.contains(x)) // Idea is that if this is true, a duplicate exists.
				return true;
			set.add(x); // Add if it's not a duplicate number for future reference.
		}
		return false;
	}
}
