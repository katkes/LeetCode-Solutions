package javsolution;

import java.util.TreeMap;

public class Solution {
	public boolean isNStraightHand(int[] hand, int groupSize) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		if (hand.length % groupSize != 0)
			return false;

		for (int num : hand) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		while (map.size() != 0) {
			int start = map.firstKey();
			int count = groupSize - 1;
			remove(start, map);
			while (count != 0) {
				if (!map.containsKey(start + 1))
					return false;
				remove(start + 1, map);
				start++;
				count--;
			}
		}

		return true;

	}

	private void remove(int key, TreeMap<Integer, Integer> map) {
		if (map.get(key) == 1)
			map.remove(key);
		else
			map.put(key, map.get(key) - 1);
	}
}
