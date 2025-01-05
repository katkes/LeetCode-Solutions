package javasolution;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public int countPalindromicSubsequence(String s) {
		int count = 0;

		HashSet<Character> left = new HashSet();
		HashMap<Character, Integer> right = new HashMap<>();
		HashSet<String> palindromeSet = new HashSet<>();

		for (Character c : s.toCharArray()) {
			right.put(c, right.getOrDefault(c, 0) + 1);
		}

		for (Character mid : s.toCharArray()) {
			if (right.get(mid) == 1)
				right.remove(mid);
			else
				right.put(mid, right.get(mid) - 1);
			for (Character edge : left) {
				String palindrome = String.valueOf(edge) + String.valueOf(mid) + String.valueOf(edge);
				if (right.containsKey(edge) && !palindromeSet.contains(palindrome)) {
					count++;
					palindromeSet.add(palindrome);
				}

			}
			left.add(mid);
		}

		return count;
	}
}