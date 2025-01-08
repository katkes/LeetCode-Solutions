package javasolution;

public class Solution {
	public String shiftingLetters(String s, int[][] shifts) {
		int[] differenceArray = new int[s.length()];

		for (int[] shift : shifts) {
			if (shift[2] == 1) {
				differenceArray[shift[0]]++;
				if (shift[1] + 1 < s.length()) {
					differenceArray[shift[1] + 1]--;
				}
			} else {
				differenceArray[shift[0]]--;
				if (shift[1] + 1 < s.length()) {
					differenceArray[shift[1] + 1]++;
				}
			}
		}

		char[] letters = s.toCharArray();

		int numOfShifts = 0;

		for (int i = 0; i < s.length(); i++) {
			numOfShifts = (numOfShifts + differenceArray[i]) % 26;

			if (numOfShifts < 0)
				numOfShifts += 26;

			letters[i] = (char) ('a' + ((letters[i] - 'a' + numOfShifts) % 26));
		}

		return new String(letters);

	}
}
