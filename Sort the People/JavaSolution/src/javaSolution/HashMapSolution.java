package javaSolution;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapSolution {
	public String[] sortPeople(String[] names, int[] heights) {
		int len = names.length;

		HashMap<Integer, String> map = new HashMap<>();

		for (int i = 0; i < len; i++) {
			map.put(heights[i], names[i]);
		}

		Arrays.sort(heights);

		for (int height : heights) {
			names[len - 1] = map.get(height);
			len--;
		}

		return names;
	}
}
