public class Solution {

	/**
	 * 
	 * Approach: The idea is that you want to hold a count array for each possible
	 * character that you have in the word. The reason is that the array can be
	 * iterated to see if by removing a letter, the conditions are met. If the
	 * conditions are not met for all of the possible characters, the result is
	 * false. A helper method is used to check if the conditions are met, called
	 * canMakeEqualFreq.
	 * 
	 * Time complexity: O(n) --> The word is iterated once, as well as the character
	 * count array being iterated once. As a result, the time complexity is linearly
	 * dependent on the size of the word.
	 * 
	 * Space complexity: O(1) --> There's only ever a fixed size array that is
	 * created to store the count per character. This array is constantly set to 26.
	 * No additional storage is needed, making it effectively O(1) space complexity.
	 * 
	 * 
	 * @param word
	 * @return
	 */
	public boolean equalFrequency(String word) {
		int[] charCount = new int[26];

		for (char c : word.toCharArray()) {
			charCount[c - 'a']++; // Subtraction offsets the character to get a 0-25 index.
		}

		for (int i = 0; i < charCount.length; i++) {
			charCount[i]--; // test a character by reducing the frequency by one
			if (canMakeEqualFreq(charCount))
				return true; // the conditions are met for a character
			charCount[i]++;
			continue;
		}

		return false;
	}

	// Helper method to test conditions
	private boolean canMakeEqualFreq(int[] charCount) {
		int max = 0;

		for (int count : charCount) {
			if (count == 0 || count == max) {
				continue;
			} else if (max == 0) {
				max = count;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}