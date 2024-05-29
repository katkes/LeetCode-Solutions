public class Solution {

	/**
	 * Approach: The solution's idea is to go through each subsection linearly.
	 * Since the substrings are sequential, that is 'acd' isn't a substring of
	 * 'abcd', only one for-loop is needed to go through all the substrings that
	 * would be viable. This is true with the sliding window approach where each
	 * window would be a potential substring to consider for the maximum length. The
	 * window shifts from the left, updated with the left variable, once a substring
	 * is over the maxCost. Each viable substring's length is considered with the
	 * current maxLength, shown with then line of maxLength = Math.max(maxLength, i
	 * - left + 1)
	 * 
	 * Time complexity: O(n) --> Since each character of the string is considered,
	 * seen with the for loop, the time complexity is O(n) where n is the length of
	 * the string. While there is a while-loop, it only shortens the current
	 * substring which still has the bounds of n itself.
	 * 
	 * Space complexity: O(1) --> There's a constant number of initializations of
	 * primitive int pointers. This makes it O(1) space complexity.
	 * 
	 * 
	 * @param s
	 * @param t
	 * @param maxCost
	 * @return
	 */
	public int equalSubstring(String s, String t, int maxCost) {
		// Initialization of left, current cost and maximum length variables
		int left = 0;
		int currentCost = 0;
		int maxLength = 0;

		// For-loop to see viable substrings, done one character of the strings at a
		// time
		for (int i = 0; i < s.length(); i++) {
			currentCost += Math.abs(Character.compare(s.charAt(i), t.charAt(i))); // Get the cost to change the
																					// inspected character

			while (currentCost > maxCost) { // Evaluates if the addition of the inspected character adds more to the
											// cost than the maxCost
				currentCost -= Math.abs(Character.compare(s.charAt(left), t.charAt(left)));
				left++; // Change the left character, would move up to the current character in the
						// worst case
			}

			maxLength = Math.max(maxLength, i - left + 1); // At this point we have a viable substring, compare the
															// current max length and the length of the viable
															// substring. The greater amount is the new max length.
		}

		return maxLength;

	}

}
