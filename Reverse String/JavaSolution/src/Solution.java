
public class Solution {

	/**
	 * Approach: The solution's approach is fairly straight forward: iterate through
	 * the array from left to right and swap the characters at any given set of
	 * pointers. (Set of pointers being a pair of left and right where the addition
	 * of the indexes equals the size of the array - 1)
	 * 
	 * Time complexity: O(n) --> The array is always iterated half way, making it
	 * O(n/2) which is denoted as O(n).
	 * 
	 * Space complexity: O(1) --> There's only a handful of char pointers that are
	 * instantiated, making it O(1).
	 * 
	 * @param s
	 */
	public void reverseString(char[] s) {
		int arrayLength = s.length;
		int left, right;
		char temp;

		for (int i = 0; i < (arrayLength / 2); i++) {
			left = i;
			right = arrayLength - i - 1;

			temp = s[left];
			s[left] = s[right];
			s[right] = temp;
		}
	}
}
