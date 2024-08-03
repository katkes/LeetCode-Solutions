package javasolution;

public class Solution {
	public boolean judgeSquareSum(int c) {
		long left = 0;
		long right = (long) Math.sqrt(c);
		long square;

		while (left <= right) {
			square = left * left + right * right;

			if (square > c)
				right--;
			else if (square < c)
				left++;
			else
				return true;
		}

		return false;
	}
}
