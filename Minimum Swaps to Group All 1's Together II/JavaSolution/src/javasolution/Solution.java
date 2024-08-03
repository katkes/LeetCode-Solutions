package javasolution;

public class Solution {

	/***
	 * 
	 * Approach: The solution uses a sliding window technique that takes advantage
	 * that there at at most as many swaps as there are 1s and that the most
	 * efficient swaps are done within a window with the most amount of ones. The
	 * number of swaps is the number of 1s minus the max amount of swaps in a given
	 * window.
	 * 
	 * Time complexity: O(n) --> The nums array is iterated once through in a linear
	 * fashion, making it O(n).
	 * 
	 * Space complexity: O(1) --> The solution is in-place outside of some int
	 * variables which are declared a constant amount of times regardless of input
	 * size.
	 * 
	 * @param nums
	 * @return
	 */
	public int minSwaps(int[] nums) {

		int len = nums.length;
		int totalNumberOf1s = 0;
		int maxNumberOnesInWindow = 0;
		int currentNumberOnesInWindow = 0;

		// Count number of ones that exists
		for (int num : nums) {
			if (num == 1) {
				totalNumberOf1s++;
			}
		}

		// Initial window
		for (int i = 0; i < totalNumberOf1s; i++) {
			if (nums[i] == 1) {
				currentNumberOnesInWindow++;
			}
		}
		maxNumberOnesInWindow = currentNumberOnesInWindow;

		// Sliding window
		for (int i = totalNumberOf1s; i < len + totalNumberOf1s; i++) {

			if (nums[(i - totalNumberOf1s) % len] == 1) {
				currentNumberOnesInWindow--;
			}

			if (nums[i % len] == 1) {
				currentNumberOnesInWindow++;
			}

			maxNumberOnesInWindow = Math.max(maxNumberOnesInWindow, currentNumberOnesInWindow);
		}

		return totalNumberOf1s - maxNumberOnesInWindow;
	}

}