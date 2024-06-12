import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		int[] ret = new int[arr1.length];
		int startIndex = 0;
		int endIndex = 0;

		for (int num : arr1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			set.add(num);
		}

		for (int num : arr2) {
			endIndex += map.get(num);
			for (int i = startIndex; i < endIndex; i++) {
				ret[i] = num;
			}
			set.remove(num);
			startIndex += map.get(num);
		}

		for (int num : set) {
			endIndex += map.get(num);
			for (int i = startIndex; i < endIndex; i++) {
				ret[i] = num;
			}
			startIndex += map.get(num);
		}

		return ret;
	}
}
