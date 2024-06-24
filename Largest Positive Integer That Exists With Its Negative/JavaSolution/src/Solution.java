import java.util.HashSet;

public class Solution {

	/***
	 * Approach: The solution's approach is to put all the numbers in the nums array
	 * into a set in order to see whether a given number is there or not in a
	 * constant time. We want this in order to see if the negative/positive version
	 * of any number is in the nums array at any time and to do this in a constant
	 * speed in Java, it's better to dump all the numbers into a HashSet, O(n) time
	 * comp, than it is to iterate over an array multiple times, O(n^2) time comp.
	 * 
	 * Time complexity: O(n) --> The nums array is iterated through at most twice.
	 * 
	 * Space complexity: O(n) --> At worst, we would enter the entire nums array in
	 * the hashset.
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxK(int[] nums) {

		int maxK = -1;

		HashSet<Integer> numbers = new HashSet<>();
		for (int num : nums) {
			numbers.add(num);
		}

		for (int num : numbers) {
			if (numbers.contains(num * -1)) {
				maxK = Math.max(Math.abs(num), maxK);
			}
		}

		return maxK;
	}
}