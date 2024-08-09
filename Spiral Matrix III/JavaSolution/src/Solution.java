
public class Solution {
	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int total = rows * cols;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[][] ret = new int[total][2];

		int row = rStart;
		int column = cStart;
		int steps = 1;
		int i = 0;
		int index = 0;

		while (index < total) {
			for (int j = 0; j < 2; j++) {
				int rowDirecition = directions[i][0];
				int columnDirection = directions[i][1];

				for (int k = 0; k < steps; k++) {
					if (row >= 0 && row < rows && column >= 0 && column < cols) {
						ret[index] = new int[] { row, column };
						index++;
					}
					row += rowDirecition;
					column += columnDirection;
				}
				i = (i + 1) % 4;
			}
			steps++;
		}

		return ret;

	}
}