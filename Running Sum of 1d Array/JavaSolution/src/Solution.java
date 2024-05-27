public class Solution {

	/**
	 * Approach: The solution's idea is to take define an array where the index i is
	 * the running sum of the numbers at i and preceding it in the nums array. With
	 * this, the first index is always the same in the running sum array and the
	 * nums array as there's no past. The solution then takes this and goes through
	 * the rest of the nums array, taking the previous entry of nums and adding it
	 * to the current index of nums.
	 * 
	 * Time complexity: Theta(n) --> The solution iterates through each term of
	 * nums. Given that nums is of the size n, the time xomplexity is the summation
	 * of one array initialization in constant time and the iteration through each
	 * number in nums, making it Theta(n+1) which is simplified to Theta(n).
	 * 
	 * Space complexity: Theta(n) --> The solution requires to construct a new array
	 * of the size n where n is the size of nums. This makes it a constant Theta(n)
	 * in terms of space complexity.
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int[] runningSum(int[] nums) {

		// Initialize the running sum array
		int[] runningSum = new int[nums.length];

		// The first number of the running sum array is always equal to the first number
		// of the original array
		runningSum[0] = nums[0];

		// Iterate through each number of the original array except the first
		for (int i = 1; i < nums.length; i++) {
			runningSum[i] = runningSum[i - 1] + nums[i]; // Take the last index of the running sum array and add to the
															// current number
		}
		return runningSum;
	}
}
