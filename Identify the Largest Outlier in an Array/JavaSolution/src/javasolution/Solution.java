package javasolution;

import java.util.HashMap;

public class Solution {
	public int getLargestOutlier(int[] nums) {

		HashMap<Integer, Integer> freqMap = new HashMap<>();
		int totalSum = 0;
		int outlier = Integer.MIN_VALUE;

		for (int num : nums) {
			totalSum += num;
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		for (int secondNumber : nums) {
			int candidate = totalSum - 2 * secondNumber;
			if (freqMap.getOrDefault(candidate, 0) > (candidate == secondNumber ? 1 : 0)) {
				outlier = Math.max(candidate, outlier);
			}
		}
		
		return outlier;

	}
}