
public class Solution {

	
	public int numSteps(String s) {

		int steps = 0;
		int carry = 0;
		int value;

		for (int i = s.length() - 1; i > -1; i++) {
			value = Character.getNumericValue(s.charAt(i)) + carry;

			if (value % 2 == 1) {
				steps += 2;
				carry = 1;
			} else {
				steps++;
			}
		}

		return steps + carry;

	}
}
