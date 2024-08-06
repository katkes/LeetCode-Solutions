package javasolution;

public class Solution {
	public int minimumPushes(String word) {
		int pushes = 0;
		int len = word.length();

		if (len < 9)
			return len;
		pushes += 8;
		len -= 8;
		if (len < 9)
			return pushes + 2 * len;
		pushes += 16;
		len -= 8;
		if (len < 9)
			return pushes + 3 * len;
		pushes += 24;
		len -= 8;
		return pushes + 4 * len;
	}
}
