package javasolution;

import java.util.HashSet;

public class Solution {
	public int numMagicSquaresInside(int[][] grid) {
		int magicSquares = 0;

		for (int row = 0; row < grid.length - 2; row++) {
			for (int column = 0; column < grid[0].length - 2; column++) {
				if (isMagic(row, column, grid))
					magicSquares++;
			}
		}

		return magicSquares;
	}

	private boolean isMagic(int row, int column, int[][] grid) {
		HashSet<Integer> set = new HashSet<>();

		for (int i = row; i < row + 3; i++) {
			for (int j = column; j < column + 3; j++) {
				if (grid[i][j] < 1 || grid[i][j] > 9)
					return false;
				set.add(grid[i][j]);
			}
		}

		if (set.size() != 9)
			return false;

		if (grid[row][column] + grid[row][column + 1] + grid[row][column + 2] != 15
				|| grid[row + 1][column] + grid[row + 1][column + 1] + grid[row + 1][column + 2] != 15
				|| grid[row + 2][column] + grid[row + 2][column + 1] + grid[row + 2][column + 2] != 15)
			return false;

		if (grid[row][column] + grid[row + 1][column] + grid[row + 2][column] != 15
				|| grid[row][column + 1] + grid[row + 1][column + 1] + grid[row + 2][column + 1] != 15
				|| grid[row][column + 2] + grid[row + 1][column + 2] + grid[row + 2][column + 2] != 15)
			return false;

		if (grid[row][column] + grid[row + 1][column + 1] + grid[row + 2][column + 2] != 15
				|| grid[row][column + 2] + grid[row + 1][column + 1] + grid[row + 2][column] != 15)
			return false;

		return true;
	}
}
