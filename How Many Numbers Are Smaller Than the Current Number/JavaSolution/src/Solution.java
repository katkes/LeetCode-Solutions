import java.util.HashMap;

public class Solution {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] answer = new int[nums.length];

		HashMap<Integer, Integer> freqMap = new HashMap<>();

		for (int number : nums) {
			freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
		}

		for (int i = 0; i < nums.length; i++) {
			answer[i] = freqMap.get(nums[i]);
		}

		return answer;
	}
}
