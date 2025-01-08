package javasolution;

import java.util.HashMap;

public class Solution {

	class TrieNode {
		HashMap<Integer, TrieNode> children = new HashMap<>();
		int count = 0;
	}

	public long countPrefixSuffixPairs(String[] words) {
		TrieNode root = new TrieNode();
		long pairs = 0;

		for (String word : words) {
			TrieNode iterator = root;
			int len = word.length();

			for (int i = 0; i < len; i++) {
				int key = word.charAt(i) + word.charAt(len - i - 1) * 128;
				iterator = iterator.children.computeIfAbsent(key, k -> new TrieNode());
				pairs += iterator.count;
			}

			iterator.count++;
		}

		return pairs;
	}

}