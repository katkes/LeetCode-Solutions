package javasolution;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
	public String[] uncommonFromSentences(String s1, String s2) {

		ArrayList<String> arrList = new ArrayList<>();

		TreeMap<String, Integer> map1 = new TreeMap<>();
		TreeMap<String, Integer> map2 = new TreeMap<>();

		String[] s1Arr = s1.split(" ");
		String[] s2Arr = s2.split(" ");

		for (String str : s1Arr)
			map1.put(str, map1.getOrDefault(str, 0) + 1);

		for (String str : s2Arr)
			map2.put(str, map2.getOrDefault(str, 0) + 1);

		for (String key : map1.keySet()) {
			if (map1.get(key) < 2) {
				if (!map2.containsKey(key))
					arrList.add(key);
			}
		}

		for (String key : map2.keySet()) {
			if (map2.get(key) < 2) {
				if (!map1.containsKey(key))
					arrList.add(key);
			}
		}

		String[] arr = new String[arrList.size()];

		return arrList.toArray(arr);

	}
}
