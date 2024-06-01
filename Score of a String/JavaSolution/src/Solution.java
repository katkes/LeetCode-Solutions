
public class Solution {

	/**
	 * Approach: The solution's idea is that the permutations of the subtraction of
	 * the characters for this question can be found linearly by iterating through
	 * each letter and comparing it to the next one. However, the last letter cannot
	 * be accessed directly in this iteration as it doesn't have a next letter,
	 * being last by definition. This is not a problem as it would be considered in
	 * letter before it. Generally speaking, each letter has two cases of it being
	 * considered except the first and last letters.
	 * 
	 * Time complexity: 0(n) --> This is a linear approach where the number of
	 * summations in the for-loop is directly linked to the length of the string.
	 * Given the string's length is n, the time complexity of this solution is O(n).
	 * 
	 * Space complexity: O(1) --> This solution only has one variable instantiated
	 * and this is always the case, no matter the size of the string given as an
	 * input. For this reason, it's constant and the space complexity is a constant
	 * O(1).
	 * 
	 * @param s
	 * @return
	 */
	public int scoreOfString(String s) {
		int score = 0; // Initialization of the score

		for (int i = 0; i < s.length() - 1; i++) { 
			score += Math.abs(Character.compare(s.charAt(i), s.charAt(i + 1))); // Character.compare takes the
																				// difference in ASCII values of two
																				// characters.
		}

		return score;
	}
}
