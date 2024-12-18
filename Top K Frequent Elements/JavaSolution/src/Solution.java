import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		PriorityQueue<Integer> heap;
		HashMap<Integer, Integer> freqMap = new HashMap<>();

		if (k == nums.length)
			return nums;

		for (int num : nums)
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

		heap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

		for (int num : freqMap.keySet()) {
			heap.add(num);
			if (heap.size() > k)
				heap.poll();
		}

		int[] top = new int[k];
		for (int i = k - 1; i >= 0; --i) {
			top[i] = heap.poll();
		}
		return top;

	}
}
