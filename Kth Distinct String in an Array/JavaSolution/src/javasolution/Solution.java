package javasolution;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {

	/**
	 * 
	 * Approach: When given a question about keeping track of occurences of
	 * elements, this itself is a good indicator to use a HashMap of some sort as it
	 * allows quick indexing of a key/value pair and tracking of a given value given
	 * a key. Recognizing this need to track whether the string is unique or not,
	 * counting the occurences allows to see if a string is unique of the occurence
	 * is only once.
	 * 
	 * Time complexity: O(n) --> The time complexity is linearly dependent as the
	 * arr array is iterated through at MOST twice. (The case where it's iterated
	 * through twice is when each string is unique)
	 * 
	 * 
	 * Space complexity: O(n) --> The additional storage needed is used for the
	 * hashMap used to store the occurences of each elemnt. The amount of space
	 * needed grows linearly with respect to the input size considering the worst
	 * case scenario is that all elements are unique.
	 * 
	 * 
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public String kthDistinct(String[] arr, int k) {
		// Frequency map
		LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();

		// Enter the frequency of each string, either as 1 or updating it by 1 if it
		// exists
		for (String str : arr) {
			hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() == 1)
				k--;
			if (k == 0)// True when reaches the kth unique string
				return entry.getKey();
		}

		return "";
	}
}