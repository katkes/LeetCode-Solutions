package javasolution;

public class Solution {
	public String shiftingLetters(String s, int[] shifts) {

		char[] letters = s.toCharArray();
		long totalShifts = 0;

		for (int i = letters.length - 1; i > -1; i--) {
			totalShifts += shifts[i];
			int newPosition = (int) ((letters[i] - 'a' + totalShifts) % 26);
			letters[i] = (char) ('a' + newPosition);
		}

		return new String(letters);
	}
}
