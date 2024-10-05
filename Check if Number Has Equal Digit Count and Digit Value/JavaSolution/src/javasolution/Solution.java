package javasolution;

import java.util.HashMap;

public class Solution {
	public boolean digitCount(String num) {

		HashMap<Integer, Integer> freqMap = new HashMap<>();
		int number;

		for (char c : num.toCharArray()) {
			number = Integer.parseInt(String.valueOf(c));
			freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
		}

		for (int i = 0; i < num.length(); i++) {
			number = Integer.parseInt(String.valueOf(num.charAt(i)));
			if (freqMap.getOrDefault(i, 0) != number)
				return false;
		}

		return true;

	}
}
