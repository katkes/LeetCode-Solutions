package javasolution;

import java.util.ArrayList;

public class Solution {

	ArrayList<ArrayList<Integer>> adjacencyList;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		adjacencyList = new ArrayList<>(numCourses);

		for (int i = 0; i < numCourses; i++)
			adjacencyList.add(new ArrayList<>());

		for (int[] prerequisite : prerequisites)
			adjacencyList.get(prerequisite[1]).add(prerequisite[0]);

		boolean[] visited = new boolean[numCourses];
		boolean[] inStack = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (dfs(i, visited, inStack))
				return false;
		}

		return true;
	}

	public boolean dfs(int node, boolean[] visited, boolean[] inStack) {
		if (inStack[node])
			return true;

		if (visited[node])
			return false;

		inStack[node] = true;
		visited[node] = true;

		for (int neighbor : adjacencyList.get(node)) {
			if (dfs(neighbor, visited, inStack))
				return true;
		}

		inStack[node] = false;
		return false;
	}

}
