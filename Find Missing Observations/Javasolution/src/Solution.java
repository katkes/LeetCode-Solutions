
public class Solution {
	public int[] missingRolls(int[] rolls, int mean, int n) {

		int[] ret = new int[n];
		int total = mean * (rolls.length + n);
		int base = 0;

		int cumulativeTotal = 0;

		for (int num : rolls)
			cumulativeTotal += num;

		if (total - cumulativeTotal > n * 6 || total < cumulativeTotal || cumulativeTotal + n > total)
			return new int[0];

		while (cumulativeTotal + n <= total) {
			base++;
			cumulativeTotal += n;
		}

		for (int i = 0; i < n; i++) {
			ret[i] = base;
		}

		int difference = total - cumulativeTotal;

		int tracker = 0;
		while (difference != 0 && tracker != n) {
			if (difference - (6 - ret[tracker]) > 0) {
				difference -= 6 - ret[tracker];
				ret[tracker] = 6;
				tracker++;
				continue;
			} else {
				ret[tracker] = ret[tracker] + difference;
				difference = 0;
				tracker++;
			}
		}

		return ret;

	}
}