package javasolution;

import java.util.HashSet;

public class Solution {

	/**
	 * Approach: The solution is to use prefix sum solution to remove the need to
	 * check the score of every possible range. This is done by keeping a running
	 * tally, used by the pref array, of the scores and using logic to get the score
	 * for a given range.
	 * 
	 * Time complexity: O(m + n) --> The code has a summation of two linear aspects,
	 * the linear check of words being valid or not and the linear checks of the
	 * queries array. Seeing that they both are independent of each other and run in
	 * a linear manner, it's best to characterize this as O(m+n) where m is the size
	 * of the words list and n is the size of the first dimension of the queries
	 * array.
	 * 
	 * Space complexity: O(n) --> The additional space grows linearly in regards to
	 * the input size.
	 * 
	 * 
	 * @param words
	 * @param queries
	 * @return
	 */
	public int[] vowelStrings(String[] words, int[][] queries) {

		int[] pref = new int[words.length + 1];
		int[] answer = new int[queries.length];
		HashSet<Character> vowelSet = new HashSet<Character>();

		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');

		pref[0] = 0;
		for (int i = 0; i < words.length; i++) {
			pref[i + 1] = pref[i];
			pref[i + 1] += (vowelSet.contains(words[i].charAt(0))
					&& vowelSet.contains(words[i].charAt(words[i].length() - 1))) ? 1 : 0;
		}

		int count = 0;
		for (int[] query : queries) {
			answer[count] = pref[query[1] + 1] - pref[query[0]];
			count++;
		}

		return answer;
	}
}