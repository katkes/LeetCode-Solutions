package javasolution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	int length;
	int width;

	public int numIslands(char[][] grid) {
		length = grid.length;
		width = grid[0].length;
		int count = 0;

		for (int row = 0; row < length; row++) {
			for (int column = 0; column < width; column++) {
				if (grid[row][column] == '1') {
					count++;
					bfs(grid, row, column);
				}
			}
		}

		return count;
	}

	private void bfs(char[][] grid, int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		int[] current = new int[] { row, column };
		queue.offer(current);

		while (!queue.isEmpty()) {
			current = queue.poll();

			for (int[] direction : directions) {
				int newRow = direction[0] + current[0];
				int newColumn = direction[1] + current[1];

				if ((0 <= newRow && newRow < length) && (0 <= newColumn && newColumn < width)
						&& (grid[newRow][newColumn] == '1')) {
					grid[newRow][newColumn] = '0';
					queue.offer(new int[] { newRow, newColumn });
				}

			}
		}

	}

}
