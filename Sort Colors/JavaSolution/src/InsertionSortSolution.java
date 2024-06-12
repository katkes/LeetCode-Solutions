
public class InsertionSortSolution {
	public void sortColors(int[] nums) {
		
		int leastIndex;
		int least;
		int temp;
		
		for (int i = 0; i < nums.length; i++) {
			least = nums[i];
			leastIndex = i;
			
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < least) {
					least = nums[j];
					leastIndex = j;
				}
			}
			if (leastIndex == i) continue;
			temp = nums[i];
			nums[i] = least;
			nums[leastIndex] = temp;
		}


	}
}
