package javasolution;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	public int[] sortJumbled(int[] mapping, int[] nums) {

		TreeMap<Integer, LinkedList<Integer>> transformedNumberMap = new TreeMap<>();
		int key;
		int value;
		int baseTen = 1;

		for (int num : nums) {
			key = 0;
			value = num;
			baseTen = 1;

			// code to transform num to key
			if (num == 0) {
				key = mapping[0];
			} else {
				while (num != 0) {
					key += baseTen * mapping[num % 10];
					num /= 10;
					baseTen *= 10;
				}
			}

			if (transformedNumberMap.containsKey(key)) {
				transformedNumberMap.get(key).add(value);
				continue;
			}

			LinkedList<Integer> list = new LinkedList<>();
			list.add(value);
			transformedNumberMap.put(key, list);
		}

		int index = 0;
		for (Map.Entry<Integer, LinkedList<Integer>> entry : transformedNumberMap.entrySet()) {
			for (int val : entry.getValue()) {
				nums[index++] = val;
			}
		}

		return nums;

	}
}