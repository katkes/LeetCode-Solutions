package javasolution;

import java.util.HashMap;

public class Solution {
	public boolean isAnagram(String s, String t) {
		int count;
		HashMap<Character, Integer> map = new HashMap<>();

		if (s.length() != t.length())
			return false;

		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		for (char c : t.toCharArray()) {
			count = map.getOrDefault(c, 0);
			if (count == 0)
				return false;
			map.put(c, --count);
		}

		return true;
	}
}