
public class DeprecatedSolution {

	/**
	 * Approach: The intuitive approach is to change the String representation of
	 * the binary number to the numeric value in base 10. This is done with the
	 * parseInt method with changing the value from base 2 to 10. From there, it
	 * would be easy to follow the rules to count the steps using the modulo
	 * operator.
	 * 
	 * Problem: I believe there's a limit to the size of the Integer.parseInt()
	 * method in terms of the String length. This is believed as this solution
	 * throws a Runtime Error of a NumberFormatException with the input of the
	 * string "1111011110000011100000110001011011110010111001010111110001".
	 * 
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public int numSteps(String s) {
		int num = Integer.parseInt(s, 2);
		int steps = 0;

		while (num != 1) {

			if (num % 2 == 0) { // Evaluated if even
				num /= 2;
			} else {
				num += 1;
			}
			steps++;
		}

		return steps;
	}
}
