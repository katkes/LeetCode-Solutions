package javaSolution;

import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<Integer> luckyNumbers(int[][] matrix) {
		LinkedList<Integer> luckyNumbers = new LinkedList<>();
		int[] minPerRow = new int[matrix.length];
		int[] maxPerColumn = new int[matrix[0].length];
		int rowMin;
		int columnMax;
		int z = 0;

		for (int[] arr : matrix) {
			rowMin = Integer.MAX_VALUE;
			for (int x : arr) {
				if (x < rowMin)
					rowMin = x;
			}
			minPerRow[z] = rowMin;
			z++;
		}

		for (int i = 0; i < matrix[0].length; i++) {
			columnMax = Integer.MIN_VALUE;
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][i] > columnMax)
					columnMax = matrix[j][i];
			}
			maxPerColumn[i] = columnMax;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == minPerRow[i] && matrix[i][j] == maxPerColumn[j]) {
					luckyNumbers.add(matrix[i][j]);
				}
			}
		}

		return luckyNumbers;
	}
}