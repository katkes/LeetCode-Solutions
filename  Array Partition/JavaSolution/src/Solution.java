import java.util.Arrays;

public class Solution {
	public int arrayPairSum(int[] nums) {
		int total = 0, len = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < len; i += 2) {
			total += nums[i];
		}

		return total;
	}
}
