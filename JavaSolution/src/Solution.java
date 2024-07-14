
public class Solution {

	/**
	 * 
	 * Approach: The solution uses the idea of a sliding window but very basically
	 * where you look at the first three numbers, determine if they're all odd and
	 * if not you slide the window that you're looking at each time until you find
	 * three consecutive odds or you go all the way and return false.
	 * 
	 * Time complexity: O(n) --> The solution is linearly dependent on the input
	 * size based off of the iteration through the array.
	 * 
	 * Space complexity: O(1) --> The solution is inplace, outside of a variable
	 * initialized for the length of the array and i.
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public boolean threeConsecutiveOdds(int[] arr) {
		int length = arr.length;

		if (length < 3)
			return false;

		for (int i = 0; i < length - 2; i++) {
			if ((arr[i] % 2 == 1) && (arr[i + 1] % 2 == 1) && (arr[i + 2] % 2 == 1))
				return true;
		}

		return false;
	}
}
