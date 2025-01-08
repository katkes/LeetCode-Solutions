package javasolution;

public class Solution {
	public int[] minOperations(String boxes) {

		int[] operations = new int[boxes.length()];
		int len = boxes.length();

		int leftBalls = 0, movesToLeft = 0, rightBalls = 0, movesToRight = 0;

		for (int i = 0; i < len; i++) {

			operations[i] += movesToLeft;
			leftBalls += boxes.charAt(i) == '1' ? 1 : 0;
			movesToLeft += leftBalls;

			int j = len - 1 - i;
			operations[j] += movesToRight;
			rightBalls += boxes.charAt(j) == '1' ? 1 : 0;
			movesToRight += rightBalls;
		}

		return operations;
	}
}
