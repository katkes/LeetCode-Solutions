import java.util.Arrays;

public class LazySolution {
	public int minIncrementForUnique(int[] nums) {

		int increments = 0;

		Arrays.sort(nums);
		int last = nums[0];
		System.out.println(Arrays.toString(nums));

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > last) {
				last = nums[i];
				continue;
			}
			increments += last + 1 - nums[i];
			nums[i] = last + 1;
			System.out.println(last);
			last = nums[i];
		}

		System.out.println(Arrays.toString(nums));

		return increments;
	}
}
