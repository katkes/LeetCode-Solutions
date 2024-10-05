package javasolution;

import java.util.Arrays;

public class Solution {
	public String largestNumber(int[] nums) {
		String largestNumber = "";
		int len = nums.length;

		String[] sortedNums = new String[len];
		for (int i = 0; i < len; i++) {
			sortedNums[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(sortedNums, (a, b) -> (b + a).compareTo(a + b));

		if (sortedNums[0].equals("0"))
			return "0";

		for (String s : sortedNums) {
			largestNumber += s;
		}

		return largestNumber;

	}
}