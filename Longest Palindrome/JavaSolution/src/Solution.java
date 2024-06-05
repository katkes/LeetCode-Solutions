import java.util.HashSet;

public class Solution {

	/**
	 * Approach: The idea is that if we wanted to build a palindrome, we would only
	 * need to know the amount of times a there's a pair of matching characters.
	 * This can be done by splitting a string to a character array and iterating
	 * through it, putting a given letter into the set if it isn't there already. In
	 * the case it does exist already, we remove the letter from the set and add two
	 * to the length as that would mean we can build a palindrome with adding these
	 * two letters to the sides of our hypothetical palindrome string. From there,
	 * if the set is not empty then that means we have room to add one more
	 * character, in this case we'll add it to the middle where the middle character
	 * would be the pivot of the palindrome, having both sides be the reverse of
	 * each other.
	 * 
	 * Time Complexity: O(n) --> This approach iterates through the string, making
	 * the base O(n). From there, we can add one operation (to check if the set is
	 * empty) which makes it O(n+1) which simplifies to O(n).
	 * 
	 * Space Complexity: O(1) --> There's a fixed amount of characters that can be
	 * in the input string. Given this and the fact we're using a set, having the
	 * property of no duplicate values, there's a constant upper limit to the size
	 * of the set, making it effectively O(1) for space complexity. (ASCII ranges
	 * from 0 to 127, having the max size of 128)
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public int longestPalindrome(String s) {
		int length = 0;
		HashSet<Character> set = new HashSet<>();

		for (char letter : s.toCharArray()) {
			if (set.contains(letter)) {
				set.remove(letter);
				length += 2;
			} else {
				set.add(letter);
			}
		}

		if (!set.isEmpty()) {
			length++;
		}

		return length;

	}
}
