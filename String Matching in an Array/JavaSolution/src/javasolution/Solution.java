package javasolution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> stringMatching(String[] words) {

		ArrayList<String> answer = new ArrayList<>();

		for (int currentIndex = 0; currentIndex < words.length; currentIndex++) {
			int[] lps = computeLPSArray(words[currentIndex]);

			for (int otherWordIndex = 0; otherWordIndex < words.length; otherWordIndex++) {
				if (currentIndex == otherWordIndex)
					continue;

				if (isSubstring(words[currentIndex], words[otherWordIndex], lps)) {
					answer.add(words[currentIndex]);
					break;
				}
			}

		}

		return answer;

	}

	private int[] computeLPSArray(String substring) {
		int[] lps = new int[substring.length()];
		int currentIndex = 1;
		int len = 0;

		while (currentIndex < substring.length()) {
			if (substring.charAt(currentIndex) == substring.charAt(len)) {
				len++;
				lps[currentIndex] = len;
				currentIndex++;
			} else {
				if (len > 0) {
					len = lps[len - 1];
				} else {
					currentIndex++;
				}
			}
		}
		return lps;

	}

	private boolean isSubstring(String substring, String main, int[] lps) {
		int mainIndex = 0;
		int subIndex = 0;

		while (mainIndex < main.length()) {
			if (main.charAt(mainIndex) == substring.charAt(subIndex)) {
				mainIndex++;
				subIndex++;
				if (subIndex == substring.length())
					return true;
			} else {
				if (subIndex > 0)
					subIndex = lps[subIndex - 1];
				else
					mainIndex++;
			}

		}

		return false;
	}
}