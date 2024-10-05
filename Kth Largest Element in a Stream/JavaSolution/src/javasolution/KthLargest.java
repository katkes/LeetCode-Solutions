package javasolution;

import java.util.PriorityQueue;

/**
 * 
 * Approach: The concept is that since we're only adding to the structure and
 * never removing from, we realistically only need to track the last k numbers
 * in order. To do this, we can utilize a min-heap data structure which allows
 * for instant access of the minimum element in it. 
 * 
 * 
 * 
 *
 */
public class KthLargest {

	private int k;
	private PriorityQueue<Integer> minHeap;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>(k);

		for (int num : nums) {
			if (minHeap.size() < k) {
				minHeap.offer(num);
			} else if (num > minHeap.peek()) {
				minHeap.offer(num);
				if (minHeap.size() > k) {
					minHeap.poll();
				}
			}
		}
	}

	public int add(int val) {
		if (minHeap.size() < k) {
			minHeap.offer(val);
		} else if (val > minHeap.peek()) {
			minHeap.offer(val);
			minHeap.poll();
		}
		return minHeap.peek();

	}

}
