package javasolution;

public class Solution {
	public int numberOfAlternatingGroups(int[] colors) {
		int groups = 0;

		for (int i = 0; i < colors.length; i++) {
			if ((colors[i % colors.length] == 0 && colors[(i + 1) % colors.length] == 1
					&& colors[(i + 2) % colors.length] == 0)
					|| (colors[i % colors.length] == 1 && colors[(i + 1) % colors.length] == 0
							&& colors[(i + 2) % colors.length] == 1))
				groups++;
		}

		return groups;
	}
}
