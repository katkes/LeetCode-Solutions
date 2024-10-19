package javasolution;

import java.util.HashMap;

public class Solution {
	public int maximumLengthSubstring(String s) {

		HashMap<Character, Integer> freqMap = new HashMap<>();
		int maxLength = 0;
		int start = 0;
		char endCharacter;

		for (int end = 0; end < s.length(); end++) {
			endCharacter = s.toCharArray()[end];

			freqMap.put(endCharacter, freqMap.getOrDefault(endCharacter, 0) + 1);

			while (freqMap.get(endCharacter) > 2) {
				char startCharacter = s.charAt(start);
				freqMap.put(startCharacter, freqMap.get(startCharacter) - 1);
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}
}
