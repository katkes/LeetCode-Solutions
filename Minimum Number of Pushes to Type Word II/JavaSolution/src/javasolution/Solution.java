package javasolution;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
	public int minimumPushes(String word) {

		int minPushes = 0;
		int first = 8;
		int second = 8;
		int third = 8;
		int frequency;
		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (char c : word.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		maxHeap.addAll(frequencyMap.values());

		while (!maxHeap.isEmpty()) {
			frequency = maxHeap.poll();
			if (first != 0) {
				minPushes += frequency;
				first--;
				continue;
			} else if (second != 0) {
				minPushes += 2 * frequency;
				second--;
				continue;
			} else if (third != 0) {
				minPushes += 3 * frequency;
				third--;
				continue;
			}
			minPushes += 4 * frequency;
		}

		return minPushes;
	}
}