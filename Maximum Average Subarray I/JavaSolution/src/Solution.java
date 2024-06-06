
public class Solution {
	/**
	 * Approach: This is a simple sliding window question where the length of the
	 * window is k, starting from index 0 where we also intialize the current sum
	 * and assign it to the rolling sum. The idea is to have a rolling sum of the
	 * window, with it sliding over one index at a time. That is why the number on
	 * the left that left the window is subtracted from the rolling sum and the new
	 * number from the right is added to the rolling sum. From there, the window
	 * average is recalculated and compared with with the max average which is
	 * returned at the end.
	 * 
	 * Time complexity: O(n) --> Since we're doing one iteration through the nums
	 * array, as well as a constant number of operations, this is summarized to an
	 * O(n) time complexity.
	 * 
	 * Space complexity: O(1) --> The solution is in place, only intializing a few
	 * int pointers which are done regardless of input size. For this reason, it's
	 * considered O(1) space complexity.
	 * 
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		double rollingSum = 0;

		for (int i = 0; i < k; i++) {
			rollingSum += nums[i];
		}

		double maxAverage = rollingSum / k;

		if (nums.length == k)
			return maxAverage;

		double windowAverage = 0;
		for (int i = k; i < nums.length; i++) {
			rollingSum -= nums[i - k];
			rollingSum += nums[i];
			windowAverage = rollingSum / k;

			maxAverage = Math.max(windowAverage, maxAverage);
		}

		return maxAverage;
	}
}
