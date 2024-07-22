package javaSolution;

import java.util.TreeMap;

public class TreeMapSolution {
	public String[] sortPeople(String[] names, int[] heights) {

		TreeMap<Integer, String> map = new TreeMap<>();
		int j = 0;

		for (int i = 0; i < heights.length; i++) {
			map.put(heights[i], names[i]);
		}

		for (Integer key : map.descendingKeySet()) {
			names[j] = map.get(key);
			j++;
		}

		return names;
	}
}
