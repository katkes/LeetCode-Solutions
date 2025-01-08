package javasolution;

public class Solution {
	public int countPrefixSuffixPairs(String[] words) {
		int pairs = 0;
		int len = words.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				String first = words[i];
				String second = words[j];

				if (first.length() > second.length())
					continue;

				if (isPrefixAndSuffix(first, second))
					pairs++;
			}
		}
		return pairs;
	}

	private boolean isPrefixAndSuffix(String first, String second) {
		return second.startsWith(first) && second.endsWith(first);
	}
}