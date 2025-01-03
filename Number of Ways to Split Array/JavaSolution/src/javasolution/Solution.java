package javasolution;

public class Solution {
	
	public int waysToSplitArray(int[] nums) {
		long left = 0, right = 0;
		int ways = 0;

		for (int num : nums) {
			right += num;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			left += nums[i];
			right -= nums[i];

			if (left >= right) {
				ways++;
			}
		}

		return ways;
	}
}