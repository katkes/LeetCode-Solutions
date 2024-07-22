package javaSolution;

public class Solution {
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int rowLength = rowSum.length;
		int columnLength = colSum.length;
		int minValue;

		int[][] matrix = new int[rowLength][columnLength];

		int row = 0, column = 0;

		while (row < rowLength && column < columnLength) {
			minValue = Math.min(rowSum[row], colSum[column]);
			matrix[row][column] = minValue;
			rowSum[row] -= minValue;
			colSum[column] -= minValue;

			if (rowSum[row] == 0) {
				row++;
			}
			if (colSum[column] == 0) {
				column++;
			}
		}

		return matrix;
	}
}
