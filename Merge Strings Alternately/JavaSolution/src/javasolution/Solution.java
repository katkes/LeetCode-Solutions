package javasolution;

public class Solution {

	/**
	 * Approach: The idea is to start the merge by alternating between strings and
	 * adding the character of a given index to a new String which is returned. The
	 * alternation is done until one of the two words is exhausted, where if they're
	 * not the same length, the longer of the two Strings is added onto the new
	 * String.
	 * 
	 * Time Complexity: O(n) --> There is an one-pass linear traversal through both
	 * Strings.
	 * 
	 * Space Complexity: O(n) --> The additional space needed with the new String
	 * grows linearly with the size of the tree.
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public String mergeAlternately(String word1, String word2) {
		int len = word1.length() < word2.length() ? word1.length() : word2.length();
		String finalString = "";

		for (int i = 0; i < len; i++) {
			finalString += word1.charAt(i);
			finalString += word2.charAt(i);
		}

		if (word1.length() != word2.length()) {
			if (word1.length() > word2.length())
				finalString += word1.substring(len);
			else
				finalString += word2.substring(len);

		}

		return finalString;
	}
}
