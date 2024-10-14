package javasolution;

import java.util.TreeMap;

public class Solution {
	public long maxKelements(int[] nums, int k) {

		long max = 0;
		int highest;

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		while (k != 0) {
			highest = map.lastKey();
			max += highest;
			if (map.get(highest) == 1)
				map.remove(highest);
			else
				map.put(highest, map.get(highest) - 1);
			map.put(Math.ceilDiv(highest, 3), map.getOrDefault(Math.ceilDiv(highest, 3), 0) + 1);
			k--;
		}

		return max;

	}
}