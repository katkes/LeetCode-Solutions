package javasolution;

public class Solution {
	public String longestDiverseString(int a, int b, int c) {

		int currentSeqA = 0, currentSeqB = 0, currentSeqC = 0;
		String ret = "";
		int totalLength = a + b + c;

		for (int i = 0; i < totalLength; i++) {

			if ((a >= b && a >= c && currentSeqA != 2) || (a > 0 && (currentSeqB == 2 || currentSeqC == 2))) {
				ret += "a";
				a--;
				currentSeqA++;
				currentSeqB = 0;
				currentSeqC = 0;
			} else if ((b >= a && b >= c && currentSeqB != 2) || (b > 0 && (currentSeqA == 2 || currentSeqC == 2))) {
				ret += "b";
				b--;
				currentSeqB++;
				currentSeqA = 0;
				currentSeqC = 0;
			} else if ((c >= b && c >= a && currentSeqC != 2) || (c > 0 && (currentSeqB == 2 || currentSeqA == 2))) {
				ret += "c";
				c--;
				currentSeqC++;
				currentSeqA = 0;
				currentSeqB = 0;
			}

		}

		return ret;
	}
}
