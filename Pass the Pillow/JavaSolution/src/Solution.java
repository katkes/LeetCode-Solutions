
public class Solution {
	public int passThePillow(int n, int time) {
		// time / (n -1) represents the number of runs there are
		return ((time / (n - 1) % 2 == 0) ? (time % (n - 1) + 1) : (n - time % (n - 1)));
	}
}
