package javasolution;

public class Solution {

	public int prefixCount(String[] words, String pref) {
		int count = 0;
		int len = pref.length();

		for (String word : words) {
			if (word.length() >= len && word.substring(0, len).equals(pref))
				count++;
		}

		return count;
	}

	// Sightly optimal solution
//	public int prefixCount(String[] words, String pref) {
//		int count = 0;
//		for (String word : words) {
//			if (word.startsWith(pref))
//				count++;
//		}
//		return count;
//	}
}