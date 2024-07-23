package javasolution;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public int[] frequencySort(int[] nums) {
		int len = nums.length;

		HashMap<Integer, Integer> frequencyMap = new HashMap<>();

		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		Integer[] integerNums = new Integer[len];
		for (int i = 0; i < len; i++) {
			integerNums[i] = nums[i];
		}

		Arrays.sort(integerNums, (a, b) -> {
			if (frequencyMap.get(a).equals(frequencyMap.get(b))) {
				return Integer.compare(b, a);
			}
			return Integer.compare(frequencyMap.get(a), frequencyMap.get(b));
		});

		for (int i = 0; i < len; i++) {
			nums[i] = integerNums[i];
		}

		return nums;

	}
}
