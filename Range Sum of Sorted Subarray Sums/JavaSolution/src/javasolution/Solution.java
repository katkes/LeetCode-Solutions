package javasolution;

import java.util.Arrays;

public class Solution {

	/**
	 * 
	 * Approach: The approach is fairly simple, first step is to find all the sums
	 * and construct the array with all subarray sums, the second is to sort it and
	 * the third is to sum the sums left to right.
	 * 
	 * Time complexity: O(n^2logn) --> The sorting is the bottle neck where the time
	 * complexity is O(logn). Because the amount of elements is n^2 where the input
	 * size is logn, the bottleneck and the solution as a result becomes O(n^2logn).
	 * 
	 * 
	 * Space complexity: O(n^2) --> All possible subarray sums must be stored,
	 * giving a O(n^2) space complexity.
	 * 
	 * 
	 * @param nums
	 * @param n
	 * @param left
	 * @param right
	 * @return
	 */
	public int rangeSum(int[] nums, int n, int left, int right) {
		long sum = 0;
		int size = n * (n + 1) / 2;
		int index = 0;
		long currentSum;

		long[] list = new long[size];

		for (int i = 0; i < n; i++) {
			currentSum = 0;
			for (int j = i; j < n; j++) {
				currentSum = (currentSum + nums[j]);
				list[index] = currentSum;
				index++;
			}
		}

		Arrays.sort(list);

		for (int i = left - 1; i < right; i++) {
			sum += list[i];
		}

		return (int) (sum % ((long) Math.pow(10, 9) + 7));
	}
}