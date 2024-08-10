package javasolution;

public class Solution {

	// Directions that you can go from a square
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	/**
	 * 
	 * Approach: The idea is that seeing the grid, it'd be best to represent it as a
	 * grid that's three time it's size based on the amount of space the slashes
	 * takes up. From that, a given tile has two properties, either slashed or not.
	 * If slashed, the tile is set to 1. DFS is performed to explore each region
	 * that can exist. The DFS allows to explore all of one region, setting the
	 * visited boolean matrix to true of a given tile if visited.
	 * 
	 * Time complexity: O(n^2) --> Given the input size being the length of grid,
	 * represented as n, the amount of tiles is 3n^2 making it O(n^2). Having to
	 * traverse all of the tiles, the operations is related by a relation of O(n^2).
	 * 
	 * Space complexity: O(n^2) --> Given the input size being the length of grid,
	 * represented as n, the amount of tiles is 3n^2 making it O(n^2). Having to
	 * store all of the tiles, the operations is related by a relation of O(n^2).
	 * 
	 * 
	 * @param grid
	 * @return
	 */
	public int regionsBySlashes(String[] grid) {
		int gridSize = grid.length;
		int[][] expandedGrid = new int[gridSize * 3][gridSize * 3];
		int regions = 0;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				int baseRow = i * 3;
				int baseCol = j * 3;

				if (grid[i].charAt(j) == '\\') {
					expandedGrid[baseRow][baseCol] = 1;
					expandedGrid[baseRow + 1][baseCol + 1] = 1;
					expandedGrid[baseRow + 2][baseCol + 2] = 1;
				} else if (grid[i].charAt(j) == '/') {
					expandedGrid[baseRow][baseCol + 2] = 1;
					expandedGrid[baseRow + 1][baseCol + 1] = 1;
					expandedGrid[baseRow + 2][baseCol] = 1;
				}
			}
		}

		boolean[][] visited = new boolean[gridSize * 3][gridSize * 3];
		for (int i = 0; i < expandedGrid.length; i++) {
			for (int j = 0; j < expandedGrid[i].length; j++) {
				if (expandedGrid[i][j] == 0 && !visited[i][j]) { // If it's not slashed nor visited
					dfs(expandedGrid, visited, i, j); // Explore an undiscovered region while marking all of it's tiles
														// as discovered
					regions++;
				}
			}
		}

		return regions;

	}

	private void dfs(int[][] grid, boolean[][] visited, int row, int column) {
		int gridSize = grid.length;
		if (row < 0 || column < 0 || row >= gridSize || column >= gridSize || grid[row][column] != 0
				|| visited[row][column]) {
			return;
		}

		visited[row][column] = true;
		for (int[] direction : DIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = column + direction[1];
			dfs(grid, visited, newRow, newCol);
		}
	}
}
