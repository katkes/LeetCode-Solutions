package javasolution;

public class Solution {

	/***
	 * 
	 * Approach: Given that the age is guaranteed to be at indexes 11 and 12, the
	 * solution uses this fact to extract the age and parse it to an integer to
	 * verify if a person is a senior or not.
	 * 
	 * Time complexity: O(n) --> Every person in the details array is considered
	 * once and these checks grows linearly with regards to the input size.
	 * 
	 * Space complexity: O(1) --> The solution is in place outside of one int
	 * pointer being used regardless of input size.
	 * 
	 * 
	 * @param details
	 * @return
	 */
	public int countSeniors(String[] details) {
		int seniors = 0;

		for (String person : details) {
			if (Integer.parseInt(person.substring(11, 13)) > 60)
				seniors++;
		}

		return seniors;
	}

}
